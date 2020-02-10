package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method to set the blue to 0 */
  public void zeroRed()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
    	for (Pixel pixelObj : rowArray)
    	{
    		pixelObj.setRed(0);
    	}
    }
  }
  
  public void zeroGreen()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (int rows = 0; rows < pixels.length; rows++)
    {
    	for (int colums = 0; colums < pixels[0].length; colums++)
    	{
    		pixels[rows][colums].setGreen(0);
    	}
    }
  }
  
  public void zeroGreen(int topRow, int topCol, int bottomRow, int bottomCol)
  {
	Pixel[][] pixels = this.getPixels2D();
	if (topRow < bottomRow && topCol < bottomCol)
	{
		if (topRow >= 0 && bottomRow < pixels.length && topCol >= 0 && topCol < pixels[0].length)
		{
		    for (int rows = topRow; rows < bottomRow; rows++)
		    {
		    	for (int colums = topCol; colums < bottomCol; colums++)
		    	{
		    		pixels[rows][colums].setGreen(0);
		    	}
		    }
		}
	}
  }
  
  public void keepOnlyRed()
  {
	  zeroGreen();
	  zeroBlue();
  }
  
  public void keepOnlyGreen()
  {
	  zeroRed();
	  zeroBlue();
  }
  
  public void keepOnlyBlue()
  {
	  zeroRed();
	  zeroGreen();
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int width = pixels[0].length;
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < width / 2; col++)
		  {
		    leftPixel = pixels[row][col];
		    rightPixel = pixels[row][width - 1 - col];
		    leftPixel.setColor(rightPixel.getColor());
		  }
	  } 
  }
  
  public void mirrorHorizontal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  for (int colum = 0; colum < pixels[0].length; colum++)
	  {
		  for (int row = 0; row < pixels.length; row++)
		  {
			  topPixel = pixels[row][colum];
			  bottomPixel = pixels[pixels.length-row-1][colum];
			  bottomPixel.setColor(topPixel.getColor());
		  }
	  }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public Pixel[][] mirrorPixelArray(Pixel[][] pixels)
  {
	Pixel[][] flipped = new Pixel[pixels.length][pixels[0].length];
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width; col++)
      {
        Pixel leftPixel = pixels[row][col];
        Pixel rightPixel = pixels[row][width - 1 - col];
        flipped[row][col] = rightPixel;
        flipped[row][width - 1 - col] = leftPixel;
      }
    } 
    return flipped;
  }
  
  public Pixel[][] placePixelsOnImage(Pixel[][] mainImage, Pixel[][] placedImage, int atX, int atY)
  {
	  for (int row = 0; row < placedImage.length; row++)
	  {
		  for (int colum = 0; colum < placedImage[0].length; colum++)
		  {
			  Pixel currentPixel = placedImage[row][colum];
			  Pixel newPixel = mainImage[row+atY][colum+atX];
			  newPixel.setColor(currentPixel.getColor());
		  }
	  }
	  return mainImage;
  }
  
  public Pixel[][] getSection(Pixel[][] from, int beginRow, int beginCol, int endRow, int endCol)
  {
	  Pixel[][] found = new Pixel[endRow-beginRow][endCol-beginCol];
	  for (int row = beginRow; row < endRow; row++)
	  {
		  for (int colum = beginCol; colum < endCol; colum++)
		  {
			  found[row-beginRow][colum-beginCol] = from[row][colum];
		  }
	  }
	  
	  return found;
  }
  
  public Pixel[][] resize(Pixel[][] starter, int scalar)
  {
	  Pixel[][] resized = new Pixel[starter.length*scalar][starter[0].length*scalar];
	  for (int row = 0; row < starter.length; row++)
	  {
		  for (int col = 0; col < starter[0].length; col++)
		  {
			  Pixel currentPixel = starter[row][col];
			  for (int i = 0; i < scalar; i++)
			  {
				  for (int j = 0; j < scalar; j++)
				  {
					  resized[(row*scalar)+i][(col*scalar)+j] = currentPixel;
				  }
			  }
		  }
	  }
	  return resized;
  }
  
  public void mirrorArm()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  
	  int beginArmRow = 159;
	  int beginArmCol = 103;
	  int endArmRow = 192;
	  int endArmCol = 172;
	  
	  // Save arm into array
	  Pixel[][] arm = new Pixel[endArmRow-beginArmRow][endArmCol-beginArmCol];
	  for (int row = beginArmRow; row < endArmRow; row++)
	  {
		  for (int colum = beginArmCol; colum < endArmCol; colum++)
		  {
			  arm[row-beginArmRow][colum-beginArmCol] = pixels[row][colum];
			  Color current = pixels[row][colum].getColor();
			  
			  pixels[row+70][colum-8].setColor(current);
		  }
	  }
	  
	  Pixel[][] mirroredArm = mirrorPixelArray(arm);
	  pixels = placePixelsOnImage(pixels, mirroredArm, 243, 235);
  }
  
  public void mirrorGull()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  
	  int beginRow = 227;
	  int beginCol = 226;
	  int endRow = 328;
	  int endCol = 354;
	  
	  // Save gull into array
	  Pixel[][] gull = getSection(pixels, beginRow, beginCol, endRow, endCol);
	  pixels = placePixelsOnImage(pixels, mirrorPixelArray(gull), 350, 280);
	  pixels = placePixelsOnImage(pixels, mirrorPixelArray(gull), 50, 350);
	  pixels = placePixelsOnImage(pixels, resize(gull, 3), 100, 0);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public int random(int min, int max)
  {
	  return (int) (Math.random() * (max-min)) + min;
  }
  
  public int random(int max)
  {
	  int min = 0;
	  return (int) (Math.random() * (max-min)) + min;
  }
  
  public boolean chance(int oneInX)
  {
	  return random(oneInX) == oneInX/2;
  }
  
  public int constrainColor(int val)
  {
	  if (val > 255)
		  return 255;
	  if (val < 0)
		  return 0;
	  return val;
  }
  
  public void removePixelColor(Pixel pix, int toRemove, int val)
  {
	  if (toRemove == 0)
		  pix.setRed(pix.getRed()/val);
	  else if (toRemove == 1)
		  pix.setGreen(pix.getGreen()/val);
	  else if (toRemove == 2)
		  pix.setBlue(pix.getBlue()/val);
  }
  
  public Pixel[][] oldRemoveChannelChunk(Pixel[][] input)
  {
	  for (int row = 0; row < input.length; row++)
	  {
		  for (int col = 0; col < input[0].length; col++)
		  {
			  if (chance(500))
			  {
				  int val = random(1, 10);

				  int chunkSizeX = random(10, 60);
				  int chunkSizeY = random(10, 60);
				  for (int i = 0; i < chunkSizeY; i++)
				  {
					  int span = chunkSizeX;
					  if (chance(5))
						  span = random(10,60);
					  for (int j = 0; j < span; j++)
					  {
						  if (row+i < input.length && col+j < input[0].length)
						  {
							  Pixel currentPixel = input[row+i][col+j];
							  removePixelColor(currentPixel, random(3), val);
						  }
					  }
				  }
			  }
		  }
	  }
	  return input;
  }
  
  public Pixel[][] removeChannelChunk(Pixel[][] input)
  {
	  int scalar = 10;
	  for (int row = 0; row < input.length; row++)
	  {
		  for (int col = 0; col < input[0].length; col++)
		  {
			  if (chance(1500))
			  {
				  int toRemove = random(3);
				  int shape = random(2);
				  int val = random(1, 10);

				  // Square
				  if (shape == 0)
				  {
					  int chunkSizeX = random(10, 60);
					  int chunkSizeY = random(10, 60);
					  for (int i = 0; i < chunkSizeY; i++)
					  {
						  int span = chunkSizeX;
						  if (chance(5))
							  span = random(10,60);
						  for (int j = 0; j < span; j++)
						  {
							  if (row+i < input.length && col+j < input[0].length)
							  {
								  Pixel currentPixel = input[row+i][col+j];
								  removePixelColor(currentPixel, toRemove, val);
							  }
						  }
					  }
				  }
				  //Triangle
				  else if (shape == 1)
				  {
					  int chunkSize = random(10, 60);
					  for (int i = 0; i < chunkSize; i++)
					  {
						  int offset = 0;
						  if (chance(5))
							  offset = random(5, i);
						  for (int j = 0; j < i-offset; j++)
						  {
							  if (row+i < input.length && col+j < input[0].length)
							  {
								  Pixel currentPixel = input[row+i][col+j];
								  removePixelColor(currentPixel, toRemove, val);
							  }
						  }
					  }
				  }
			  }
		  }
	  }
	  return input;
  }
  
  public void oldGlitch()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int randomRow = random(pixels.length);
	  int randomCol = random(pixels[0].length);
	  
	  int startRow = random(randomRow);
	  int startCol = random(randomCol);
	  
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  Pixel currentPixel = pixels[row][col];
			  Color pixelColor = currentPixel.getColor();
			  int offset = random(0, 200);
			  int red = constrainColor(pixelColor.getRed() + random(-offset, offset));
			  int green = constrainColor(pixelColor.getGreen() + random(-offset, offset));
			  int blue = constrainColor(pixelColor.getBlue() + random(-offset, offset));
			  
			  
			  Color randomColor = new Color(red, green, blue);
			  
			  currentPixel.setColor(randomColor);
		  }
	  }
	  
	  pixels = oldRemoveChannelChunk(pixels);
  }
  
  public void glitch()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int randomRow = random(pixels.length);
	  int randomCol = random(pixels[0].length);
	  
	  int startRow = random(randomRow);
	  int startCol = random(randomCol);
	  
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  Pixel currentPixel = pixels[row][col];
			  Color pixelColor = currentPixel.getColor();
			  int offset = random(50, 100);
			  int red = constrainColor(pixelColor.getRed() + random(-offset, offset));
			  int green = constrainColor(pixelColor.getGreen() + random(-offset, offset));
			  int blue = constrainColor(pixelColor.getBlue() + random(-offset, offset));
			  
			  
			  Color randomColor = new Color(red, green, blue);
			  
			  currentPixel.setColor(randomColor);
		  }
	  }
	  
	  pixels = removeChannelChunk(pixels);
  }
  
  public void negate()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rows : pixels)
	  {
		  for (Pixel pixel : rows)
		  {
			  Color color = pixel.getColor();
			  Color mod = new Color(255-color.getRed(), 255-color.getGreen(), 255-color.getBlue());
			  pixel.setColor(mod);
		  }
	  }
  }
  
  public void grayscale()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rows : pixels)
	  {
		  for (Pixel pixel : rows)
		  {
			  Color color = pixel.getColor();
			  int avg = (color.getRed() + color.getGreen() + color.getBlue())/3;
			  Color mod = new Color(avg, avg, avg);
			  pixel.setColor(mod);
		  }
	  }
  }
  
  public int depressColor(int c, int avg, int depressioness)
  {
	  return (c + (avg * depressioness)) / (depressioness+1);
  }
  
  public void depression()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rows : pixels)
	  {
		  for (Pixel pixel : rows)
		  {
			  Color color = pixel.getColor();
			  int avg = (color.getRed() + color.getGreen() + color.getBlue())/3;
			  int dep = 9;
			  Color mod = new Color(depressColor(color.getRed(), avg, dep), depressColor(color.getGreen(), avg, dep), depressColor(color.getBlue(), avg, dep));
			  pixel.setColor(mod);
		  }
	  }
  }
  
  public void depression(int bRow, int bCol)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int dep = random(1, 6);
	  int eRow = random(bRow, pixels.length);
	  int eCol = random(bCol, pixels[0].length);
	  for (int row = bRow; row < eRow; row++)
	  {
		  for (int col = bCol; row < eCol; col++)
		  {
			  Color color = pixels[row][col].getColor();
			  int avg = (color.getRed() + color.getGreen() + color.getBlue())/3;
			  Color mod = new Color(depressColor(color.getRed(), avg, dep), depressColor(color.getGreen(), avg, dep), depressColor(color.getBlue(), avg, dep));
			  pixels[row][col].setColor(mod);
		  }
	  }
  }
  
  public void fixUnderwater()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rows : pixels)
	  {
		  for (Pixel pixel : rows)
		  {
			  Color color = pixel.getColor();
			  if (color.getRed() < 20 && color.getBlue() > 150)
				  pixel.setColor(Color.white);
		  }
	  }
  }
  
  public void addText(String message, int x, int y, int fontSize)
  {
    Graphics2D graphics2d = this.createGraphics();
    int offset = 2;
    graphics2d.setFont(new Font("Luminari",Font.BOLD,fontSize));

    //Shadow
    graphics2d.setPaint(Color.black);
    graphics2d.drawString(message,x-offset,y+offset);
    graphics2d.drawString(message,x,y-offset);
    graphics2d.drawString(message,x+offset,y);
    //Main
    graphics2d.setPaint(Color.white);
    graphics2d.drawString(message,x,y);
  }
  
  public boolean colorInThreshold(Color inputColor, Color compareColor)
  {
	  int redDiff = Math.abs(inputColor.getRed() - compareColor.getRed());
	  int greenDiff = Math.abs(inputColor.getGreen() - compareColor.getGreen());
	  int blueDiff = Math.abs(inputColor.getBlue() - compareColor.getBlue());
	  int threshold = 100;
	  return redDiff + greenDiff + blueDiff <= threshold;
  }
  
  public void chromakey(Picture background, Color replaceColor)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel[][] backgroundPixels = background.getPixels2D();
	  // Remove replace color
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < pixels[row].length; col++)
		  {
			  Pixel currentPixel = pixels[row][col];
			  if (colorInThreshold(currentPixel.getColor(), replaceColor))
			  {
				  Pixel backgroundPixel = backgroundPixels[row][col];
				  currentPixel.setColor(backgroundPixel.getColor());
			  }
		  }
	  }
  }
  

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    PictureTester.testMethods();
  }
  
} // this } is the end of class Picture, put all new methods before this
