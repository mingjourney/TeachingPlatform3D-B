package com.healthy.heathy.test;


import com.lilittlecat.chatgpt.offical.ChatGPT;
import com.lilittlecat.chatgpt.offical.entity.Message;
import okhttp3.OkHttpClient;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Gugu
 * @create 2023-05-02 21:12
 * @purpose
 */
public class Test {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        OkHttpClient client = new OkHttpClient.Builder().
                proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 21002))).connectTimeout(5000,TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .build();
        ChatGPT chatGPT = new ChatGPT("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",client);
        String hello = "日计划模块，需要你根据我给的用户的信息定制相应日计划JSON格式给我，格式如下：\n" +
                "{ \"reason\": \"在这个计划中，我进行了一些微调，主要是在饮食和训练方面做了一些变化。在饮食方面，我增加了蛋白质的摄入，增加了早餐中的鸡蛋数量；在训练方面，我将全身力量训练变味背部力量训练，以全面锻炼身体的不同部位。\", \"slogan\": \"坚持下去，你会发现自己的无限潜力！\", \"timeSlots\": [ { \"time\": \"07:00 - 08:00\", \"activity\": \"晨跑 (30分钟)\" }, { \"time\": \"12:00 - 13:00\", \"activity\": \"午餐：炒菜花(100g)、红烧鸡块(150g)、米饭(1.5碗)\" }, { \"time\": \"16:30 - 17:00\", \"activity\": \"晚餐：牛排(150g)、沙拉(100g)\" }, { \"time\": \"18:00 - 19:30\", \"activity\": \"健身房锻炼 - 背部 (90分钟)\" }, { \"time\": \"23:00 - 7:00\", \"activity\": \"睡觉\" } \\] }）；\n" +
                "周计划格式：JSON\n" +
                "[ { key: '1', date: '星期一', breakfast: '燕麦粥(10g)、鸡蛋(1个)、苹果(1个)', lunch: '炒菜花(100g)、红烧鸡块(150g)、米饭(1.5碗)', dinner: '炖土豆(150g)、清蒸鱼(230g)、米饭(1碗)', exercise: '跑步(30分钟)、健身-背(60分钟)', calories: '-105kal', }, { key:....},一周7天 ]\n" +
                "\n" +
                "你的推荐需要科学参考用户的所有信息，以及下面之后对话中他每天录入的日程信息，做出规划和调整，不用给我代码块以外的字\n" +
                "你能否完成任务";
        String ask = "请帮用户名为“远方传来风笛”的用户定制日计划；其中他之前设立的目标如下，在2023.6月瘦到64kg,并且健身入门；下面是截止昨天平台保存的这位用户的数据，远方传来风笛，身高174cm，体重73kg,年龄23岁，性别男，学生，爱好是打篮球、健身、跑步等，以及多项球类运动，由于这是他第一次制定日计划，所以没有之前的运动与饮食数据，请制定2023.5.6的日计划（只有json形式，不要其他语句）";
        List<Message> messages = new ArrayList<>();
        messages.add(Message.builder()
                .role("user")
                .content(hello)
                .build());

        messages.add(Message.builder()
                .role("user")
                .content(ask)
                .build());
        System.out.println(chatGPT.ask(messages));
        System.out.println(System.currentTimeMillis()-l);
    }
}
