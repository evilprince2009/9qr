import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        String data = "https://www.github.com/evilprince2009";
        String path = ".\\images\\link-to-gh.png";
        int dimension = 200;
        try {
            generateQRCode(data, path, dimension);
            System.out.println("QR Code created successfully. Please check the file at " + path);
        } catch (Exception ex) {
            System.out.println("QR Code creation failed: " + ex.getMessage());
        }
    }

    private static void generateQRCode(String data, String path, int dimension) throws Exception {
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes("UTF-8"), "UTF-8"), BarcodeFormat.QR_CODE, dimension, dimension);
        MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    }
}
