package cn.devcorp.demo.exception;

public class CompleteException {

    private void imooc1() throws Exception {
        throw new Exception("imooc1 has exception...");
    }

    private void imooc2() throws Exception {

        try {
            imooc1();
        } catch (Exception ex) {
            throw new Exception("imooc2 has exception...", ex);
        }
    }

    private void imooc3() {
        try {
            imooc2();
        } catch (Exception ex) {
            throw new RuntimeException("imooc3 has exception...", ex);
        }
    }

    public static void main(String[] args) {

        try {
            new CompleteException().imooc3();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}