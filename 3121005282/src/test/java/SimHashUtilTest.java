

/*import static org.junit.jupiter.api.Assertions.*;*/

import org.junit.jupiter.api.Test;

class SimHashUtilTest {

    @Test
    void getHash() {
        System.out.println(SimHashUtil.getHash("hdhc"));
    }

   @Test
    void getSimHash() {
       System.out.println(SimHashUtil.getSimHash("kzdfvj"));
    }

    @Test
    void getHammingDistance() {
    }

    @Test
    void getSimilarity() {
        String simHash1 = SimHashUtil.getSimHash("dklcz");
        String simHash2 = SimHashUtil.getSimHash("dklcz");
        System.out.println(SimHashUtil.getSimilarity(simHash1,simHash2));
    }
}