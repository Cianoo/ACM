package day20190309;

/**
 * 百钱百鸡问题：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。
 * 百钱买百鸡，问鸡翁，鸡母，鸡雏各几何？
 */
public class Baiqianbaiji {
    public static void main(String[] args) {
        int mChicken;   //鸡翁数量
        int fChicken;   //鸡母数量
        int lChicken;   //鸡雏数量

        for (mChicken=0; mChicken<=20; mChicken++){
            for (fChicken=0; fChicken<=33; fChicken++){
                lChicken = 100-fChicken-mChicken;   //鸡雏数量

                if (
                        lChicken+fChicken+mChicken         == 100&
                        lChicken*1/3+fChicken*3+mChicken*5 == 100&
                        lChicken % 3                       == 0
                                                            ){
                    System.out.println("鸡翁："+mChicken+"鸡母:"+fChicken+"鸡雏:"+lChicken);
                }
            }
        }
    }
}
