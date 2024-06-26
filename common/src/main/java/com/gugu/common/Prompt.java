package com.gugu.common;

/**
 * @author Gugu
 * @create 2023-05-06 20:07
 * @purpose
 */
public class Prompt {
    public static final String datePlan = "日计划模块，需要你根据我给的用户的信息定制相应日计划JSON格式给我，格式如下：\n" +
            "{ \"reason\": \"在这个计划中，我进行了一些微调，主要是在饮食和训练方面做了一些变化。在饮食方面，我增加了蛋白质的摄入，增加了早餐中的鸡蛋数量；在训练方面，我将全身力量训练变味背部力量训练，以全面锻炼身体的不同部位。\", \"slogan\": \"坚持下去，你会发现自己的无限潜力！\", \"timeSlots\": [ { \"time\": \"07:00 - 08:00\", \"activity\": \"晨跑 (30分钟)\" }, { \"time\": \"12:00 - 13:00\", \"activity\": \"午餐：炒菜花(100g)、红烧鸡块(150g)、米饭(1.5碗)\" }, { \"time\": \"16:30 - 17:00\", \"activity\": \"晚餐：牛排(150g)、沙拉(100g)\" }, { \"time\": \"18:00 - 19:30\", \"activity\": \"健身房锻炼 - 背部 (90分钟)\" }, { \"time\": \"23:00 - 7:00\", \"activity\": \"睡觉\" } \\] }）；\n" +
            "周计划格式：JSON\n" +
            "[ { key: '1', date: '星期一', breakfast: '燕麦粥(10g)、鸡蛋(1个)、苹果(1个)', lunch: '炒菜花(100g)、红烧鸡块(150g)、米饭(1.5碗)', dinner: '炖土豆(150g)、清蒸鱼(230g)、米饭(1碗)', exercise: '跑步(30分钟)、健身-背(60分钟)', calories: '-105kal', }, { key:....},一周7天 ]\n" +
            "\n" +
            "你的推荐需要科学参考用户的所有信息，以及下面之后对话中他每天录入的日程信息，做出规划和调整，不用给我代码块以外的字\n" +
            "你能否完成任务";



}
