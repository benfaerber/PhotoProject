package pixLab.classes;
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
    beach.zeroGreen();
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
    Picture mark = new Picture("blue-mark.jpg");
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
	  //snowman.mirrorArms();
	  snowman.explore();
  }
  
  public static void testMirrorGull()
  {
	  Picture gull = new Picture("seagull.jpg");
	  gull.explore();
	  //gull.mirrorGull();
	  gull.explore();
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
    //testZeroGreen(); // Complete
    //testKeepOnlyBlue(); // Complete
    //testKeepOnlyRed(); // Complete
    //testKeepOnlyGreen(); // Complete
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical(); // Complete
    //testMirrorVerticalRightToLeft(); // Complete
    //testMirrorTemple(); // Complete
    //testMirrorHorizontal(); // Complete
    testMirrorArms();
    testMirrorGull();
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