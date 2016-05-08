package ar.com.jgt.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 Prefijos normalizados - Gustavo, 2012-11-26.

 @author Joselo
 */
public class BackgroundImage implements Border {

    /** The Constant BACKGROUND_IMAGE. */
    private static final String BACKGROUND_IMAGE = "/ar/com/jgt/icons_128x128/Logo500x250.png";
    /** The m_background. */
    private BufferedImage m_background;

    /**
     Instantiates a new background image.
     */
    public BackgroundImage() {
        try {
            //se obtiene la imagen
            String l_str = getClass().getResource(BACKGROUND_IMAGE).toString();
            URL l_url = new URL(l_str);
            m_background = ImageIO.read(l_url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(BackgroundImage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BackgroundImage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /* (non-Javadoc)
     @see javax.swing.border.Border#getBorderInsets(java.awt.Component)
     */
    @Override
    public Insets getBorderInsets(Component p_comp) {
        return new Insets(0, 0, 0, 0);
    }

    /* (non-Javadoc)
     @see javax.swing.border.Border#isBorderOpaque()
     */
    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    /* (non-Javadoc)
     @see javax.swing.border.Border#paintBorder(java.awt.Component,
     java.awt.Graphics, int, int, int, int)
     */
    @Override
    public void paintBorder(Component p_comp, Graphics p_gr, int p_x, int p_y,
            int p_width, int p_height) {
        //se dibuja la imagen de fondo en el centro del contenedor
        //cada que se redimensione el contenedor, la imagen automaticamente se posiciona en el centro
        p_gr.drawImage(m_background, (p_x + (p_width - m_background.getWidth()) / 2), (p_y + (p_height - m_background.getHeight()) / 2), null);
    }
}
