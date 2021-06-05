/* First week task
 * Here we learn to input the text file in our java code and made certain changes.
 * This program is about calculating the permiter of shape ( the shape maybe triangle, square or rectangle)
 * For the task they gave four datasets and example text files, which we were instructed to put in the code and execute it.
 * 
 */
//import
import edu.duke.*;
import java.io.File;
//class with PermiterofShape name
public class PerimeterAssignmentRunner 
{
    // Method 1 : to get the input
    public int getNumPoints (Shape s) 
    {
        int numPoints = 0;
        for(Point p : s.getPoints())
        {
            numPoints += 1;
        }
        return numPoints;
    }
    
    //Method 2 : to find the avergae length
    public double getAverageLength(Shape s) 
    {
        double length = getPerimeter(s);
        double numSides = (double) getNumPoints(s);
        double avgLength = length / numSides;
        return avgLength;
    }

    //Method 3 : here we find the largest side of the shape we took
    public double getLargestSide(Shape s) 
    {
        Point lastPoint = s.getLastPoint();
        double largestSide = 0.0;
        
        for(Point p : s.getPoints())
        {
            double dist = lastPoint.distance(p);
            if(dist > largestSide) 
            {
                largestSide = dist;
            }
            lastPoint = p;
        }
        return largestSide;
    }

    //Method 4 
    public double getLargestX(Shape s) 
    {
        Point lastPoint = s.getLastPoint();
        int lastPointX = lastPoint.getX();
        double largestX = (double) lastPointX;
        
        for(Point p : s.getPoints())
        {
            int newX = p.getX();
            if(newX > largestX) 
            {
                largestX = (double) newX;
            }
        }
        return largestX;
    }

    //Method 5 : This method is to find the largest perimeter of the multiple files(files were given)
    public double getLargestPerimeterMultipleFiles() 
    {
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        FileResource largestFile = null;

        for(File f : dr.selectedFiles())
        {
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if(perim > largestPerim) 
            {
                largestPerim = perim;
            }
        }
        return largestPerim;
    }

    //Method 6 : In this method we have designed an algorithm to get the file with largest perimeter
    public String getFileWithLargestPerimeter() 
    {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File largestFile = null;

        for(File f : dr.selectedFiles())
        {
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if(perim > largestPerim) 
            {
                largestPerim = perim;
                largestFile = f;
            }
        }

        return largestFile.getName();
    }

    //Method 7 
    public void testPerimeterMultipleFiles() 
    {
        double largest = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter is: " + largest);
    }

    //Method 8
    public void testFileWithLargestPerimeter() 
    {
        String file = getFileWithLargestPerimeter();
        System.out.println("Largest perimeter file is: " + file);
    }
    
    //Method 9
    public double getPerimeter (Shape s) 
    {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) 
        {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle()
    {
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints())
        {
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }
    
    public void testPerimeter () 
    {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        
        System.out.println("perimeter = " + length);
        System.out.println("Number of Points: " + numPoints);
        System.out.println("Average Length: " + averageLength);
        System.out.println("Largest Side: " + largestSide);
        System.out.println("Largest X is: " + largestX );
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() 
    {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) 
        {
            System.out.println(f);
        }
    }

    public static void main (String[] args) 
    {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}