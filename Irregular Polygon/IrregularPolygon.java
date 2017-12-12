import java.awt.geom.*;
import java.util.ArrayList;
import gpdraw.*;

public class IrregularPolygon{
   private ArrayList <Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

   public IrregularPolygon(){}

   public void add(Point2D.Double aPoint){
       this.myPolygon.add(aPoint);
   }

   public void draw(){
       SketchPad sp = new SketchPad(500, 500);
       DrawingTool pen = new DrawingTool(sp);
       pen.move(this.myPolygon.get(0).getX(), myPolygon.get(0).getY());
       pen.down();
       for(int i = 0; i < this.myPolygon.size(); i++){
           pen.move(this.myPolygon.get(i).getX(), myPolygon.get(i).getY());
       }
       pen.move(this.myPolygon.get(0).getX(), myPolygon.get(0).getY());
   }

   public double perimeter(){
       double perim = 0.0;
       for(int i = 0; i < this.myPolygon.size(); i++){
           int j = i + 1;
           if(j == this.myPolygon.size())j = 0;
           perim += this.myPolygon.get(i).distance(this.myPolygon.get(j));
       }
       return perim;
   }

   public double area(){
       double area = 0.0;
       for(int i = 0; i < this.myPolygon.size(); i++){
           int j = i + 1;
           if(j == this.myPolygon.size()) j = 0;
           area += this.myPolygon.get(i).getX()*this.myPolygon.get(j).getY() - this.myPolygon.get(i).getY()*this.myPolygon.get(j).getX();
       }
       return area/2;
   }
   
   public String getName(){
       return "Evgeny Pobachienko";
   }
}