
package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;
import org.junit.Test;

public class testsearch{
    @Test
    public void test1() {
        Graph test5 = new AdjacencyListGraph();
        Vertex v0 = new Vertex("00");
        Vertex v1 = new Vertex("01");
        Vertex v2 = new Vertex("02");
        Vertex v3 = new Vertex("03");
        Vertex v4 = new Vertex("04");
        Vertex v5 = new Vertex("05");
        Vertex v6 = new Vertex("06");
        Vertex v7 = new Vertex("07");
        Vertex v8 = new Vertex("08");
        Vertex v9 = new Vertex("09");
        Vertex v10 = new Vertex("10");
        Vertex v11 = new Vertex("11");
        Vertex v12 = new Vertex("12");
        Vertex v13 = new Vertex("13");
        Vertex v14 = new Vertex("14");
        Vertex v15 = new Vertex("15");
        Vertex v16 = new Vertex("16");
        Vertex v17 = new Vertex("17");
        Vertex v18 = new Vertex("18");
        Vertex v19 = new Vertex("19");
        Vertex v20 = new Vertex("20");
        Vertex v21 = new Vertex("21");
        Vertex v22 = new Vertex("22");
        Vertex v23 = new Vertex("23");
        Vertex v24 = new Vertex("24");
        Vertex v25 = new Vertex("25");
        Vertex v26 = new Vertex("26");
        Vertex v27 = new Vertex("27");
        Vertex v28 = new Vertex("28");
        Vertex v29 = new Vertex("29");
        Vertex v30 = new Vertex("30");
        Vertex v31 = new Vertex("31");
        Vertex v32 = new Vertex("32");

        test5.addVertex(v0);
        test5.addVertex(v1);
        test5.addVertex(v2);
        test5.addVertex(v3);
        test5.addVertex(v4);
        test5.addVertex(v5);
        test5.addVertex(v6);
        test5.addVertex(v7);
        test5.addVertex(v8);
        test5.addVertex(v9);
        test5.addVertex(v10);
        test5.addVertex(v11);
        test5.addVertex(v12);
        test5.addVertex(v13);
        test5.addVertex(v14);
        test5.addVertex(v15);
        test5.addVertex(v16);
        test5.addVertex(v17);
        test5.addVertex(v18);
        test5.addVertex(v19);
        test5.addVertex(v20);
        test5.addVertex(v21);
        test5.addVertex(v22);
        test5.addVertex(v23);
        test5.addVertex(v24);
        test5.addVertex(v25);
        test5.addVertex(v26);
        test5.addVertex(v27);
        test5.addVertex(v28);
        test5.addVertex(v29);
        test5.addVertex(v30);
        test5.addVertex(v31);
        test5.addVertex(v32);

        test5.addEdge(v0,v1);
        test5.addEdge(v0,v5);
        test5.addEdge(v0,v18);

        test5.addEdge(v1,v5);
        test5.addEdge(v1,v4);
        test5.addEdge(v1,v2);

        test5.addEdge(v2,v9);
        test5.addEdge(v2,v17);
        test5.addEdge(v2,v18);
        test5.addEdge(v2,v19);

        test5.addEdge(v3,v4);
        test5.addEdge(v3,v16);

        test5.addEdge(v4,v5);

        test5.addEdge(v6,v8);

        test5.addEdge(v7,v12);
        test5.addEdge(v7,v10);
        test5.addEdge(v7,v16);

        test5.addEdge(v9,v10);
        test5.addEdge(v9,v14);

        test5.addEdge(v10,v11);
        test5.addEdge(v10,v13);
        test5.addEdge(v10,v14);
        test5.addEdge(v10,v15);

        test5.addEdge(v11,v13);

        test5.addEdge(v12,v14);
        test5.addEdge(v12,v16);
        test5.addEdge(v12,v18);

        test5.addEdge(v15,v20);

        test5.addEdge(v17,v19);

        test5.addEdge(v19,v20);

        test5.addEdge(v21,v23);

        test5.addEdge(v22,v23);

        test5.addEdge(v23,v24);
        test5.addEdge(v23,v27);

        test5.addEdge(v24,v25);
        test5.addEdge(v24,v27);

        test5.addEdge(v25,v26);

        test5.addEdge(v28,v30);
        test5.addEdge(v28,v31);

        test5.addEdge(v29,v30);
        test5.addEdge(v29,v31);

        System.out.println(Algorithms.breadthFirstSearch(test5));
        System.out.println(Algorithms.depthFirstSearch(test5));

    }

}

