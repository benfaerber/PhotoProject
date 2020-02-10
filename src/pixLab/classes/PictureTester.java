package pixLab.classes;

import java.awt.Color;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testZeroRed()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroRed();
    beach.explore();
  }
  
  public static void testZeroGreen()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroGreen(50, 50, 100, 100);
    beach.explore();
  }
  
  public static void testKeepOnlyRed()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepOnlyRed();
    beach.explore();
  }
  
  public static void testKeepOnlyGreen()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepOnlyGreen();
    beach.explore();
  }
  
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture mark = new Picture("caterpillar.jpg");
    mark.explore();
    mark.mirrorVertical();
    mark.explore();
  }
  
  public static void testMirrorVerticalRightToLeft()
  {
	Picture mark = new Picture("blue-mark.jpg");
	mark.explore();
	mark.mirrorVerticalRightToLeft();
	mark.explore();
  }
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testMirrorArms()
  {
	  Picture snowman = new Picture("snowman.jpg");
	  snowman.explore();
	  snowman.mirrorArm();
	  snowman.explore();
  }
  
  public static void testMirrorGull()
  {
	  Picture gull = new Picture("seagull.jpg");
	  gull.explore();
	  gull.mirrorGull();
	  gull.explore();
	  gull.write("/Users/wfae1302/Desktop/gull.jpg");
  }
  
  public static void testMirrorHorizontal()
  {
	  Picture arch = new Picture("arch.jpg");
	  arch.explore();
	  arch.mirrorHorizontal();
	  arch.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testGlitch()
  {
	  Picture arch = new Picture("arch.jpg");
	  arch.explore();
	  arch.oldGlitch();
	  arch.explore();
	  
	  arch = new Picture("arch.jpg");
	  arch.explore();
	  arch.glitch();
	  arch.explore();
  }
  
  public static void testNegate()
  {
	  Picture arch = new Picture("arch.jpg");
	  arch.explore();
	  arch.negate();
	  arch.explore();
  }
  public static void testGrayscale()
  {
	  Picture arch = new Picture("arch.jpg");
	  arch.explore();
	  arch.depression();
	  arch.explore();
  }
  public static void testFixUnderwater()
  {
	  Picture water = new Picture("water.jpg");
	  water.explore();
	  water.fixUnderwater();
	  water.explore();
	  water.write("/Users/wfae1302/Desktop/water.jpg");
  }
  
  public static void testChromakey()
  {
	  Picture source = new Picture("hotties.jpg");
	  Picture background = new Picture("background.jpg");
	  Color replaceColor = new Color(0, 255, 0);
	  source.explore();
	  source.chromakey(background, replaceColor);
	  source.depression();
	  source.addText("Me and Kevin checking our potatos (Ireland 1847)", 150, 75, 32);
	  source.addText("How they lookin' Ben?", 358, 189, 20);
	  source.addText("Blimey, Kev' they're black and moldy!", 676, 420, 20);
	  source.explore();
	  System.out.println(source.write("/Users/wfae1302/Desktop/irelandMeme.jpg"));
  }
  
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    testMethods();
  }
  
  public static void testMethods()
  {
	// uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
	testGlitch();
    //testZeroGreen(); // Complete
    //testKeepOnlyBlue(); // Complete
    //testKeepOnlyRed(); // Complete
	//testZeroGreen();
	  
    //testKeepOnlyGreen(); // Complete
    //testNegate(); // Complete
    //testGrayscale(); // Complete
    //testFixUnderwater(); // Complete
    //testMirrorVertical(); // Complete
    //testMirrorVerticalRightToLeft(); // Complete
    //testMirrorTemple(); // Complete
    //testMirrorHorizontal(); // Complete
    //testMirrorArms(); // Complete
    //testMirrorGull(); // Complete
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
	//testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}