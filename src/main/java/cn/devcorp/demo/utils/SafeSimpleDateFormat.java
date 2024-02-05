//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cn.devcorp.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SafeSimpleDateFormat {
    private final String _format;
    private static final ThreadLocal _dateFormats = ThreadLocal.withInitial(HashMap::new);

    private SimpleDateFormat getDateFormat(String format) {
        Map<String, SimpleDateFormat> formatters = (Map)_dateFormats.get();
        return formatters.computeIfAbsent(format, SimpleDateFormat::new);
    }

    public SafeSimpleDateFormat(String format) {
        this._format = format;
    }

    public String format(Date date) {
        return this.getDateFormat(this._format).format(date);
    }

    public String format(Object date) {
        return this.getDateFormat(this._format).format(date);
    }

    public Date parse(String day) throws ParseException {
        return this.getDateFormat(this._format).parse(day);
    }
}
