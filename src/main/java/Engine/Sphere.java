package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class Sphere extends Circle{
    Float radiusZ;
    int sectorCount;


    List<Integer> index;
    int ibo;
    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color,
                  List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;

       createEllipsoid();
//
        setupVAOVBO();

    }
    public void createBox(){
        vertices.clear();
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //Titik 1 kiri atas belakang
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 2 kiri bawah belakang
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 3 kanan bawah belakang
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 4 kanan atas belakang
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 5 kiri atas depan
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 6 kiri bawah depan
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 7 kanan bawah depan
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 8 kanan atas depan
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));
        //kotak depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));
        //kotak samping kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(4));

        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak samping kanan
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));
        //kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak bawah
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
    }
    public void createSphere(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        int stackCount = 18, sectorCount = 36;
        float x,y,z,xy,nx,ny,nz;
        float sectorStep = (float)(2* Math.PI )/ sectorCount; //sector count
        float stackStep = (float)Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        //titik persegi
        for(int i=0;i<=stackCount;i++){
            stackAngle = (float)Math.PI/2 - i * stackStep;
            xy = (float) (0.5f * Math.cos(stackAngle));
            z = (float) (0.5f * Math.sin(stackAngle));
            for(int j=0;j<sectorCount;j++){
                sectorAngle = j * sectorStep;
                x = (float) (xy * Math.cos(sectorAngle));
                y = (float) (xy * Math.sin(sectorAngle));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i=0;i<stackCount;i++){
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
                if(i != 0){
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1+1);
                }
                if(i!=(18-1)){
                    temp_indices.add(k1+1);
                    temp_indices.add(k2);
                    temp_indices.add(k2+1);
                }
            }
        }

        this.index = temp_indices;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,
                ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,
                Utils.listoInt(index), GL_STATIC_DRAW);

    }

    public void createHalfEllipsoid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/90){
            for(double u = -Math.PI/2; u<= Math.PI/1.99; u+=Math.PI/90){
                float x = 0.6f * (float)(Math.cos(v) * Math.cos(u));
                float y = 0.5f * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createEllipsoid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/90){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/90){
                float x = 0.6f * (float)(Math.cos(v) * Math.cos(u));
                float y = 0.5f * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createElipticCylinder(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/90){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/90){
                float x = 0.5f * (float)(Math.sin(u));
                float y = 0.5f * (float)(Math.cos(u));
                float z = 0.5f * (float) v;
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices.clear();
        vertices = temp;
    }
    public void createHyeperboloid2side(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/60){
                float x = 0.1f * (float)(Math.tan(v) * Math.cos(u));
                float y = 0.1f * (float)(Math.tan(v) * Math.sin(u));
                float z = 0.1f * (float)(1/Math.cos(v));
                temp.add(new Vector3f(x,z,y));
            }

        }
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60) {
            for (double u = Math.PI / 2; u <= 3 * Math.PI / 2; u += Math.PI / 60) {
                float x = 0.3f * (float) (Math.tan(v) * Math.cos(u));
                float y = 0.3f * (float) (Math.tan(v) * Math.sin(u));
                float z = -0.3f * (float) (1 / Math.cos(v));
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createElipticCone(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/90){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/90){
                float x = 0.5f * (float)(v * Math.cos(u));
                float y = 0.5f * (float)(v * Math.sin(u));
                float z = 0.5f * (float)(v);
                temp.add(new Vector3f(z,y,x));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createElipticParaboloid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 1; v+=0.005){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(v * Math.cos(u));
                float y = 0.5f * (float)(v * Math.sin(u));
                float z = (float) Math.pow(v,2);
                temp.add(new Vector3f(z,y,x));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createHalfElipticParaboloid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 1; v+=0.005){
            for(double u = -Math.PI; u<= Math.PI/100; u+=Math.PI/60){
                float x = 0.5f * (float)(v * Math.cos(u));
                float y = 0.5f * (float)(v * Math.sin(u));
                float z = (float) Math.pow(v,2);
                temp.add(new Vector3f(z,y,x));
            }
        }
        vertices.clear();
        vertices = temp;
    }
    public void createHalfElipticParaboloid2(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 1; v+=0.005){
            for(double u = -Math.PI/200; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(v * Math.cos(u));
                float y = 0.5f * (float)(v * Math.sin(u));
                float z = (float) Math.pow(v,2);
                temp.add(new Vector3f(z,y,x));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createHyperboloidParaboloid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 1; v+=0.05){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.2f * (float)(v * Math.tan(u));
                float y = 0.2f * (float)(v * 1/Math.sin(u));
                float z = (float) Math.pow(v,2);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices.clear();
        vertices = temp;
    }
//    public void draw(){
//        drawSetup();
//        //Bind IBO & draw
//        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
//        glDrawElements(GL_TRIANGLES,
//                index.size(),
//                GL_UNSIGNED_INT, 0);
//    }
//
//    public void drawLine(){
//        drawSetup();
//        // Draw the vertices
//        glLineWidth(1);
//        glPointSize(1);
//        glDrawArrays(GL_LINE_STRIP, 0,
//                vertices.size());
//    }
}