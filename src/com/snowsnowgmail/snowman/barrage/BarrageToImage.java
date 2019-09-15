package com.snowsnowgmail.snowman.barrage;

import java.util.LinkedList;
import java.util.List;

public class BarrageToImage {
    public static String code;
    public static int size = 10;
    public static int goalFrame = 60;

    public static List<Bullet> bullets = new LinkedList<>();

    public final static String optionHelp =
            "使用方法\n" +
                    "java com.snowsnowgmail.snowman.barrage.BarrageToImage [options...] <CodeString>\n\n" +
                    "オプションは次の通りです\n\n" +
                    "-h\n" +
                    "-help\n" +
                    "-?\n" +
                    "\tヘルプを出力します。";

    /**
     * @param args 起動引数
     */
    public static void loadCommandLine(String[] args) {
        String codeString = null;

        //起動引数が０の時
        if (args.length == 0) {
            System.out.println(optionHelp);
            System.exit(0);
        }

        for (int i = 0; i < args.length; i++) {
            try {
                if (args[i].startsWith("-")) {
                    args[i] = args[i].toLowerCase();
                    switch (args[i]) {
                        case "-h":
                        case "-help":
                        case "-?":
                            System.out.println(optionHelp);
                            System.exit(0);
                        default:
                            System.err.printf("unknown option \"%s\" found\n", args[i]);
                            System.err.println(optionHelp);
                            System.exit(-1);
                    }
                } else {
                    //オプションの様でないなら、
                    codeString = args[i];
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.printf("\"%s\" needs some data", args[i - 1]);
                System.exit(-1);
            }
        }
        if (codeString == null) {
            System.err.println("code string is not put");
            System.err.println(optionHelp);
            System.exit(-1);
        }
        code = codeString;
    }

    public static void main(String[] args) {
        loadCommandLine(args);
    }
}
