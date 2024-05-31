package cn.devcorp.demo.controller;

import net.suuft.libretranslate.Language;
import net.suuft.libretranslate.Translator;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/5/28 14:41
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@RestController
public class DemoController {
    @GetMapping("translate")
    public String translate(@RequestParam String from,@RequestParam String fromLan,@RequestParam String toLan){
        Translator.setUrlApi("http://192.168.0.150:5353");
        return Translator.translate(Language.CHINESE, Language.ENGLISH, from);
    }
    @GetMapping("ceshi")
    public void demo(@RequestParam String s ){
        System.out.println(s);
    }
}
