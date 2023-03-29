import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GeradorDeImagens {
    public void Cria(InputStream file, String outPutName) throws IOException {
        BufferedImage originalImage = ImageIO.read(file);
        //cria nova imagem em memoria com transparencia e tamnho novo
        int largura = originalImage.getWidth();
        int altura  = originalImage.getHeight();
        int novaAltura = altura + 200;
        var newImage = new BufferedImage(largura,novaAltura, BufferedImage.TRANSLUCENT);

        //copia imagem original para nova imagem
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0,0, null);

        //Configura a font
        Font fonte = new Font(Font.DIALOG_INPUT, Font.BOLD, 64);
        graphics.setFont(fonte);
        graphics.setColor(Color.ORANGE);
        var imageText = "Hello!";
        int X = (largura - imageText.length()) / 2;
        int Y = novaAltura - 100;
        //Escrever uma frase na imagem
        graphics.drawString( imageText, X, Y);

        //escrever a nova imagem em um arquivo
        outPutName = outPutName.replaceFirst(" ","");
        File directory = new File("Saida");
        if (!directory.exists()) {
            directory.mkdirs(); // creates the directory and any necessary but nonexistent parent directories.
        }
        File filePath = new File( directory , outPutName + ".png");
        ImageIO.write(newImage, "png", filePath);
    }
}
