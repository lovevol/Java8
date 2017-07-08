package excutedAround;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lh
 * on 2017/7/8.
 */
/*
环绕执行模式
即在方法所必需的代码中间，你需要执行点儿什么操作，比如资源分配和清理
* */
public class ExecuteAroundTest {
    public static void main(String[] args) {
        try {
            //传入不同的参数
            System.out.println(processFile(BufferedReader::readLine));
            System.out.println(processFile((BufferedReader br)->br.readLine()+br.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String processFile(BufferedReaderProcess brp) throws IOException {//函数式接口作为参数
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"));
        return brp.process(bufferedReader);

    }
}
