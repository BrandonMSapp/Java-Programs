import java.util.ArrayList;

public class Graph {
    static class Edge{
        String source;
        String destination;
        int cost;
        public Edge(String source, String destination, int cost)
        {
            this.source = source;
            this.destination = destination;
            this.cost = cost;
        }
    }
    
    static ArrayList<String> vertices = new ArrayList<>();
    static ArrayList <Edge>  edgeList = new ArrayList <>();
    
    public static void loadVertices(ArrayList<String []> strings)
    {
        for(int i = 0; i < strings.size(); i++)
        {
            if(strings.get(i).length == 3)
            {
                for(int j = 0; j < 2; j++)
                {
                    if(vertices.contains(strings.get(i)[j]) == false)
                    {
                        addVertex(strings.get(i)[j]);
                    } 
                }
            }
            else if(strings.get(i).length == 1)
            {
                if(vertices.contains(strings.get(i)[0]) == false)
                {
                    addVertex(strings.get(i)[0]);
                }
            }
        }
        
    }
    
    
    public static void loadEdges(ArrayList<String []> strings)
    {
        for(int i = 0; i < strings.size(); i++)
        {
            if(strings.get(i).length == 3)
            {
                addEdge(strings.get(i)[0], strings.get(i)[1], 
                        Integer.parseInt(strings.get(i)[2]));
            }
        }
        
    }
    
    
    public static boolean addEdge(String source, String destination, int cost)
    {
        Edge edge = new Edge(source, destination, cost);
        if(vertices.contains(source) && vertices.contains(destination))
        {
            edgeList.add(edge);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    public static boolean removeEdges(String source, String destination)
    {
        if(vertices.contains(source) && vertices.contains(destination))
        {
            for(int i = 0; i < edgeList.size(); i++)
            {
                if(edgeList.get(i).source.compareTo(source) == 0 && 
                       edgeList.get(i).destination.compareTo(destination) == 0)
                {
                    edgeList.remove(i);
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    
    public static void addVertex(String name)
    {
        vertices.add(name);
    }
    
    
    public boolean removeVertex(String name)
    {
        if(vertices.contains(name))
        {
            for(int j = 0; j < vertices.size(); j++)
            {
                if(vertices.get(j) == name)
                {
                    vertices.remove(j);
                }
            }
            for (int i = 0; i < edgeList.size(); i++)
            {
                if(edgeList.get(i).source.compareTo(name) == 0 || 
                        edgeList.get(i).destination.compareTo(name) == 0)
                {
                    edgeList.remove(i);
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    public static boolean contains(String name)
    {
        if(vertices.contains(name))
        {
           return true; 
        }
        else
        {
            return false;
        }
        
    }
    
    
    public static boolean contains(String source, String destination)
    {
        for(int i = 0; i < edgeList.size(); i++)
        {
            if(edgeList.get(i).source.compareTo(source) == 0 && 
                    edgeList.get(i).destination.compareTo(destination) == 0)
            {
                return true;
            }
        }
        return false;
    }
    
    
    public static void numVertices()
    {
        System.out.println("Number of Vertices: " + vertices.size());
    }
    
    
    public static void zeroInbound() 
    {
        System.out.print("Vertices with zero inbound edges: ");
        for(int i = 0; i < vertices.size(); i++)
        {
            for(int j = 0; j <= edgeList.size(); j++)
            {
                if(j == edgeList.size())
                {
                    System.out.print(vertices.get(i) + "   ");
                    break;
                }
                if(edgeList.get(j).destination.compareTo(vertices.get(i)) == 0)
                {
                    break;
                }
            }
        }
        System.out.println();
    }
    
    
    public static void selfEdges()
    {
        System.out.print("Vertices with self edges: ");
        for(int i = 0; i < edgeList.size(); i++)
        {
            if(edgeList.get(i).source.compareTo(edgeList.get(i).destination) 
                    == 0)
            {
                System.out.print(edgeList.get(i).source + "   ");
            }
        }
        System.out.println();
    }
    
    
    public static void zeroOutbound() 
    {
        System.out.print("Vertices with zero outbound edges: ");
        for(int i = 0; i < vertices.size(); i++)
        {
            for(int j = 0; j <= edgeList.size(); j++)
            {
                if(j == edgeList.size())
                {
                    System.out.print(vertices.get(i) + "   ");
                    break;
                }
                if(edgeList.get(j).source.compareTo(vertices.get(i)) == 0)
                {
                    break;
                }
            }
        }
        System.out.println();
    }
    
    
    public static void heaviestWeight()
    {
        System.out.print("Edge(s) with heaviest weight: ");
        Edge max = edgeList.get(0);
        for(int i = 0; i < edgeList.size(); i++)
        {
            if(edgeList.get(i).cost > max.cost)
            {
                max = edgeList.get(i);
            }
        }
        for(int j = 0; j < edgeList.size(); j++)
        {
            if(edgeList.get(j).cost == max.cost)
            {
                System.out.print(edgeList.get(j).source + " " + 
            edgeList.get(j).destination + "   ");
            }
        }
  
    }
    
}
