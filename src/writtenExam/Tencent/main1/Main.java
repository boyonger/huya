package writtenExam.Tencent.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        boolean flag = false;
        int twoMul = n + 1;
        int threeMul = 1;
        int divTwo = n;
        int divThree = n+1;
        int m = n + 1;
        for (int i = n + 1; i <= m; i++) {
            divTwo = divNumber(divTwo, i);
            twoMul = mulNumber(twoMul, i, divNumber(twoMul, i));
        }
        for (int i = 1; i <= m; i++) {
            divThree = divNumber(divThree, i);
            threeMul = mulNumber(threeMul, i, divNumber(threeMul, i));
        }
        if (threeMul == twoMul) {
            flag = true;
        } else {
            m+=divThree;
        }
        while (!flag) {
            twoMul = mulNumber(twoMul, m, divNumber(twoMul, m));
            threeMul = mulNumber(threeMul, m, divNumber(threeMul, m));
            if (threeMul == twoMul) {
                flag = true;
            } else {
                m+=divThree;
            }
        }
        System.out.println(m);
    }

    //下面是最大公约数以及最小公倍数的算法
    /*
    a>b
    辗转相除法：两个正整数a和b（a>b），它们的最大公约数等于a除以b的余数c和b之间的最大公约数。
    比如10和25，25除以10商2余5,那么10和25的最大公约数，等同于10和5的最大公约数。
     */
    public static int divNumber(int a, int b) {
        return a % b == 0 ? b : divNumber(b, a % b);
    }

    public static int mulNumber(int a, int b, int divNumber) {
        return a * b / divNumber;
    }
}
