package cn.edu.scau.pos220.generator;

public class SnGenerator {
    private String productSn;

    public SnGenerator() {
    }

    public SnGenerator(Long productId) {
        String s = String.valueOf(System.currentTimeMillis() + productId);
        HashGenerator hashGenerator = new HashGenerator(s);
        productSn = hashGenerator.getMD5();
    }

    public String getSn() {
        return productSn;
    }
}
