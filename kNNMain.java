import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{
    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
	System.out.println("Please enter a file name that you want analyse");
	System.out.println("breastCancer.csv           ");
	System.out.println("data2DBinary.csv           ");
	System.out.println("data2DOneVsAll.csv         ");
	System.out.println("dataML.csv                 ");
	System.out.println("handwrittenDigits.csv      ");
	System.out.println("iris.csv                   ");
	System.out.println("microchip.csv              ");

	String input= null;
	Scanner userinput = new Scanner(System.in); 
	input = userinput.nextLine();	
	
	List<DataPoint> MyData=DataSet.readDataSet("C:\\Users\\ziang\\w19-360420-machine-learning\\data\\"+input);
	
	DataPoint dp3 = MyData.get(3);
	
	System.out.println(""+dp3.getLabel());
	
	System.out.println(Arrays.toString(dp3.getX()));


    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
	double fractionTrainingSet = 0.4;
	List<DataPoint> xxx = DataSet.getTrainingSet(MyData,fractionTrainingSet);
	
	double fractionTestSet = 0.6;
	List<DataPoint> qqq= DataSet.getTestSet(MyData,fractionTestSet);

    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)
	
	
    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
	 
	 // initiation of an object && create 
	  int GGG = 3;
      KNNClassifier classifier = new KNNClassifier(GGG);

      DataPoint[] somepointsnearby = classifier.getNearestNeighbors(MyData, MyData.get(0)); 
	  // get somedatapoints that is the nearest point of the First datapoint
	  
      System.out.println("Nearest points is : ");
      
	  System.out.println(" ");
	  System.out.println(" ");
	  
      for(int k = 0; k < somepointsnearby.length; k++) 
      {
        for (int p = 0; p < somepointsnearby[k].x.length; p++) 
        
	    System.out.print(somepointsnearby[k].x[p] + "  ");
        System.out.println(somepointsnearby[k].getLabel()); 
      }


    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
	
	
	double cube[]= new double[1000];
	for (int z=0; z<1000; z++)
	{	
		
		int Rubik=0;
		for(int i=0; i<(xxx.size()); i++)
		{
			DataPoint cplusplus = xxx.get(i);
			String rob = classifier.predict(xxx, cplusplus);
			if (rob.equals(cplusplus.label))
			{
				Rubik++;
			}
		}
		cube[z]=(((double)Rubik/(double)(xxx.size()))*100.0);
	}
	System.out.println("the mean is "+ Mean(cube) + "%");
	System.out.println("the standard deviation is  is "+ StandardDeviation(cube));
  }
	public static double Mean(double[] RUA){
    double sum = 0.0;

    for (double q : RUA){
      sum += q;
    }
    return (double)sum/RUA.length;
    }

   
   // like the name said  
   // this will give a standarddeviation
   // but this is require Mean 
   //  method above 
   public static double StandardDeviation(double[] RUA){
    double avg = Mean(RUA);
    double sum = 0.0;
    for (double q : RUA){
      sum += Math.pow(q-avg,2);
     }
    return (double)sum/RUA.length;
      }

	
  }


