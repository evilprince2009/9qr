import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.File;
import java.util.Scanner;

public class Main {
    private static final Scanner buffer = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Input Data: ");
        String data = buffer.next();
        System.out.print("Save file path: ");
        String path = buffer.next();
        System.out.print("Filename: ");
        String filename = buffer.next();
        buffer.close();

        String fullDir = path + "\\" + filename + ".png";
        int dimension = 500;
        try {
            generateQRCode(data, fullDir, dimension);
            System.out.println("QR Code created successfully. Please check the file at " + path);
        } catch (Exception ex) {
            System.out.println("QR Code creation failed: " + ex.getMessage());
        }
    }

    private static void generateQRCode(String data, String path, int dimension) throws Exception {
        final String charset = "UTF-8";
        byte[] bytes = data.getBytes(charset);
        String container = new String(bytes, charset);
        MultiFormatWriter formatWriter = new MultiFormatWriter();
        BitMatrix matrix = formatWriter.encode(container, BarcodeFormat.QR_CODE, dimension, dimension);
        MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    }
}
