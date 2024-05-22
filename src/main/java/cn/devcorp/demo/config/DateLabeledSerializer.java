package cn.devcorp.demo.config;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.time.temporal.ChronoField.EPOCH_DAY;

/**
 * Description: 日期时间标签化
 * 显示至分钟
 * 如果是今天/昨天/明天，则显示为：今天/昨天/明天 12:00
 * @author wenxiaopeng
 * @date 2023/2/10 12:52
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2021. All Rights Reserved.
 * </pre>
 */
@Slf4j
public class DateLabeledSerializer extends Jdk8DateCodec implements ObjectSerializer, ObjectDeserializer {

    private final static String YMDHM = "yyyy-MM-dd HH:mm";
    private final static DateTimeFormatter FORMATTER_YMDHM = DateTimeFormatter.ofPattern(YMDHM);
    private final static String YMD = "yyyy-MM-dd";
    private final static DateTimeFormatter FORMATTER_YMD = DateTimeFormatter.ofPattern(YMD);
    private final static String HM = " HH:mm";
    private final static DateTimeFormatter FORMATTER_HM = DateTimeFormatter.ofPattern(HM);
    private final static String S_TODAY = "今天";
    private final static String S_YSTD = "昨天";

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object == null) {
            serializer.writeNull();
        } else {
            if (fieldType == null) {
                fieldType = object.getClass();
            }
            if (fieldType == Date.class) {
                LocalDateTime dateTime = DateUtil.asLocalDateTime((Date) object);
                serializer.out.writeString(this.format(dateTime, true));
            } else if (fieldType == LocalDate.class) {
                serializer.out.writeString(this.format(((LocalDate) object).atStartOfDay(), false));
            } else if (fieldType == LocalDateTime.class) {
                serializer.out.writeString(this.format((LocalDateTime) object, true));
            } else {
                super.write(serializer, object, fieldName, fieldType, features);
            }
        }
    }

    private String format(LocalDateTime dateTime, boolean withTime) {
        long today = LocalDate.now()
                .getLong(EPOCH_DAY);
        long day = dateTime.getLong(EPOCH_DAY);
        long gap = (int) (today - day);
        if (Math.abs(gap) > 1) {
            if (withTime) {
                return dateTime.format(FORMATTER_YMDHM);
            } else {
                return dateTime.format(FORMATTER_YMD);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (gap == 0) {
            sb.append(S_TODAY);
        } else if (gap == 1) {
            sb.append(S_YSTD);
        }
        if (withTime) {
            sb.append(dateTime.format(FORMATTER_HM));
        }
        return sb.toString();
    }

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        T t;
        JSONLexer lexer = parser.lexer;
        if (lexer.token() == JSONToken.NULL) {
            lexer.nextToken();
            t = null;
            return t;
        }

        if (lexer.token() == JSONToken.LITERAL_STRING) {
            String text = lexer.stringVal();
            t = this.ex(type, lexer, text);
            return t;
        }

        t = super.deserialze(parser, type, fieldName);
        return t;
    }

    private <T> T ex(Type type, JSONLexer lexer, String text) {
        if (StringUtils.isBlank(text)) {
            return null;
        }
        if (extracted(type, lexer, text)) {
            return getT(type, lexer, text);
        }
        return null;
    }

    private <T> boolean extracted(Type type, JSONLexer lexer, String text) {
        if (text.contains("天")) {
            return true;
        }
        return false;
    }

    @Nullable
    private <T> T getT(Type type, JSONLexer lexer, String text) {
        T t = null; // Initialize t to null. This will also be our default return value.
        lexer.nextToken();
        LocalDate now = LocalDate.now();

        // Update text if it starts with S_TODAY or S_YSTD.
        if (text.startsWith(S_TODAY)) {
            text = text.replace(S_TODAY, now.format(FORMATTER_YMD));
        } else if (text.startsWith(S_YSTD)) {
            text = text.replace(S_YSTD, now.minusDays(1).format(FORMATTER_YMD));
        } else {
            // If text doesn't start with S_TODAY or S_YSTD, return null.
            return t;
        }

        // We can now parse the text based on the type.
        if (type == LocalDate.class) {
            t = (T) super.parseLocalDate(text, null, FORMATTER_YMD);
        } else if (type == Date.class) {
            try {
                t = (T) DateUtils.parseDate(text, YMDHM, DateUtil.DateStyle.ALL.getStyle());
            } catch (ParseException e) {
                // If parsing fails, t will remain null.
                log.info("e:{}",e.getMessage());
            }
        } else {
            t = (T) super.parseDateTime(text, FORMATTER_YMDHM);
        }

        // Return the result (which could be null if parsing failed for Date).
        return t;
    }

}
