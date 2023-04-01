package Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GeradorDeImagens {
    public void Cria(InputStream file, String outPutName, String imageText) throws IOException {
        BufferedImage originalImage = ImageIO.read(file);
        //cria nova imagem em memoria com transparencia e tamnho novo
        int largura = originalImage.getWidth();
        int altura  = originalImage.getHeight();
        int novaAltura = altura + 200;
        var newImage = new BufferedImage(largura,novaAltura, BufferedImage.TRANSLUCENT);

        //copia imagem original para nova imagem
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0,0, null);
        int textSize = (int) ((int)largura * 0.1);
        //Configura a font
        Font fonte = new Font(Font.DIALOG_INPUT, Font.BOLD, textSize);
        graphics.setFont(fonte);
        graphics.setColor(Color.ORANGE);
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D rectangleText = fontMetrics.getStringBounds(imageText, graphics);
        int larguraText = (int) rectangleText.getWidth();
        int X = (largura - larguraText) / 2;
        int Y = novaAltura - 100;
        //Escrever uma frase na imagem
        graphics.drawString( imageText, X, Y);

        //escrever a nova imagem em um arquivo
        outPutName = outPutName.trim().replaceFirst(" ","_");
        File directory = new File("Imagens");
        if (!directory.exists()) {
            directory.mkdirs(); // creates the directory and any necessary but nonexistent parent directories.
        }
        File filePath = new File( directory , outPutName + ".png");
        if(!filePath.exists()){
            ImageIO.write(newImage, "png", filePath);
        }
    }
}
