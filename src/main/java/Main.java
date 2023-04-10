import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window =
            new Window
                    (800,800,"Hello World");
    private ArrayList<Object> objects
            = new ArrayList<>();
//    private ArrayList<Object2d> objectsRectangle
//            = new ArrayList<>();
//    private ArrayList<Object2d> objectsStars
//            = new ArrayList<>();
//    private ArrayList<Object2d> objectsCircle
//            = new ArrayList<>();
//    private ArrayList<Object2d> objectsCircle2
//            = new ArrayList<>();

//    private ArrayList<Object2d> objectsPointsControl
//            = new ArrayList<>();

//    ArrayList<Object2d> objectsCurve = new ArrayList<Object2d>();

//    ArrayList<Vector2f> tempPos = new ArrayList<>();

    public void init(){
        window.init();
        GL.createCapabilities();

        //code
//        objects.add(new Object2d(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.0f,0.0f,1.0f,1.0f)
//        ));
//
//        objects.add(new Object2d(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/sceneWithVerticesColor.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/sceneWithVerticesColor.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f)
//                        )
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(1.0f,0.5f,0.0f),
//                                new Vector3f(0.0f,1.0f,0.0f),
//                                new Vector3f(0.0f,0.0f,1.0f)
//                        )
//                )
//        ));
//

        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f,0.5f,0.0f),
                                new Vector3f(-0.5f,-0.5f,0.0f),
                                new Vector3f(0.5f,-0.5f,0.0f),
                                new Vector3f(0.5f,0.5f,0.0f)
                        )
                ),
                new Vector4f(0.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f
        ));
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag"
//                                , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.940f, 0.577f, 0.103f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.5f,
//                0.5f,
//                0.5f
//        ));
//        objects.get(0).scaleObject(0.5f,0.5f,0.5f);
//
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag"
//                                , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.780f, 0.700f, 0.343f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.5f,
//                0.5f,
//                0.5f
//        ));
//        objects.get(1).translateObject(3.25f, 0.0f, 0.0f);
//        objects.get(1).scaleObject(0.1f,0.1f,0.1f);
//
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag"
//                                , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.570f, 0.437f, 0.00f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.5f,
//                0.5f,
//                0.5f
//        ));
//        objects.get(2).translateObject(3.15f, 0.0f, 0.0f);
//        objects.get(2).scaleObject(0.15f,0.15f,0.15f);
//
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag"
//                                , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.160f, 0.747f, 0.800f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.5f,
//                0.5f,
//                0.5f
//        ));
//        objects.get(3).translateObject(3.35f, 0.0f, 0.0f);
//        objects.get(3).scaleObject(0.2f,0.2f,0.2f);
//
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag"
//                                , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.510f, 0.510f, 0.510f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.5f,
//                0.5f,
//                0.5f
//        ));
//        objects.get(4).translateObject(16.2f, 0.0f, 0.0f);
//        objects.get(4).scaleObject(0.05f,0.05f,0.05f);
//
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag"
//                                , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.430f, 0.0258f, 0.0258f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.5f,
//                0.5f,
//                0.5f
////        ));
//        objects.get(5).translateObject(7f, 0.0f, 0.0f);
//        objects.get(5).scaleObject(0.13f,0.13f,0.13f);

        objects.get(0).scaleObject(2.0f, 2.0f, 2.0f);
        objects.get(0).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f,0.5f,0.0f),
                                        new Vector3f(-0.5f,-0.5f,0.0f),
                                        new Vector3f(0.5f,-0.5f,0.0f),
                                        new Vector3f(0.5f,0.5f,0.0f)
                                )
                        ),
                        new Vector4f(0.0f,1.0f,1.0f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.125f,
                        0.125f,
                        0.125f
                )
        );
        objects.get(0).getChildObject().get(0).translateObject(0.25f,0.0f,0.0f);

        objects.get(0).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f,0.5f,0.0f),
                                        new Vector3f(-0.5f,-0.5f,0.0f),
                                        new Vector3f(0.5f,-0.5f,0.0f),
                                        new Vector3f(0.5f,0.5f,0.0f)
                                )
                        ),
                        new Vector4f(0.0f,1.0f,1.0f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.125f,
                        0.125f,
                        0.125f
                )
        );
        objects.get(0).getChildObject().get(1).translateObject(0.5f,0.0f,0.0f);

        objects.get(0).getChildObject().get(1).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f,0.5f,0.0f),
                                        new Vector3f(-0.5f,-0.5f,0.0f),
                                        new Vector3f(0.5f,-0.5f,0.0f),
                                        new Vector3f(0.5f,0.5f,0.0f)
                                )
                        ),
                        new Vector4f(0.0f,1.0f,1.0f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.125f,
                        0.125f,
                        0.125f
                )
        );
        objects.get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.5f, 0.5f, 0.0f);
        objects.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.5f, -0.1f, 0.5f);
    }


    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 0.0f,
                    0.0f);
            GL.createCapabilities();
            input();



            //code

//            for(Object2d object: objectsCircle){
//                object.drawCircle();
////            }
//            for(Object2d object: objectsStars){
//                object.drawStar();
//            }
//            for(Object2d object: objectsRectangle){
//                object.draw();
//            }
//            for(Object2d object: objectsCircle){
//                object.drawCircle();
//            }
            for(Object object: objects){
                object.draw();
            }

            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    public void input(){
//        ArrayList<Object2d> tempCirlce = new ArrayList<>();
        if(window.isKeyPressed(GLFW_KEY_G)) {
            if (window.isKeyPressed(GLFW_KEY_G)){
                objects.get(0).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
                Vector3f temp = objects.get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//
                objects.get(1).translateObject(-temp.x,-temp.y,0f);
                objects.get(1).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
                objects.get(1).translateObject(temp.x,temp.y,0f);
                temp = objects.get(2).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//
                objects.get(2).translateObject(-temp.x,-temp.y,0f);
                objects.get(2).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
                objects.get(2).translateObject(temp.x,temp.y,0f);
                temp = objects.get(3).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//
                objects.get(3).translateObject(-temp.x,-temp.y,0f);
                objects.get(3).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
                objects.get(3).translateObject(temp.x,temp.y,0f);
                temp = objects.get(5).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//
                objects.get(5).translateObject(-temp.x,-temp.y,0f);
                objects.get(5).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
                objects.get(5).translateObject(temp.x,temp.y,0f);
//            objects.get(1).rotateObject((float) Math.toRadians(0.5f),0f,0f,0f);
//            objects.get(2).rotateObject((float) Math.toRadians(0.5f),0f,0f,0f);
//            objects.get(3).rotateObject((float) Math.toRadians(0.5f),0f,0f,0f);
//            objects.get(5).rotateObject((float) Math.toRadians(0.5f),0f,0f,0f);
            }
        }
        if(window.isKeyPressed(GLFW_KEY_F)) {
            objects.get(1).rotateObject((float)Math.toRadians(1.7f), 0.0f, 0.0f, 1.0f);
//            objects.get(1).rotateObject((float)Math.toRadians(1.0f), 0.0f, 0.0f, 1.0f);
            objects.get(2).rotateObject((float)Math.toRadians(1.6f), 0.0f, 0.0f, 1.0f);
            objects.get(3).rotateObject((float)Math.toRadians(1.5f), 0.0f, 0.0f, 1.0f);
            objects.get(4).rotateObject((float)Math.toRadians(1.5f), 0.0f, 0.0f, 1.0f);
            objects.get(5).rotateObject((float)Math.toRadians(1.4f), 0.0f, 0.0f, 1.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_H)){
            Vector3f bumi = objects.get(3).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//
            objects.get(4).translateObject(-bumi.x,-bumi.y,0f);
            objects.get(4).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
            objects.get(4).translateObject(bumi.x,bumi.y,0f);
        }
        if (window.isKeyPressed(GLFW_KEY_W)){
            objects.get(0).rotateObject(((float) Math.toRadians(0.5f)), 0.0f, 0.0f, 1.0f);
            for(Object child:objects.get(0).getChildObject()){
                Vector3f tempCenterPoint = child.updateCenterPoint();
                child.translateObject(tempCenterPoint.x*-1, tempCenterPoint.y*-1,
                        tempCenterPoint.z*-1);
                child.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                child.translateObject(tempCenterPoint.x, tempCenterPoint.y,
                        tempCenterPoint.z);
            }

            for(Object child:objects.get(0).getChildObject().get(1).getChildObject()){
                Vector3f tempCenterPoint = objects.get(0).getChildObject().get(1).updateCenterPoint();
                child.translateObject(tempCenterPoint.x*-1, tempCenterPoint.y*-1,
                        tempCenterPoint.z*-1);
                child.rotateObject((float) Math.toRadians(0.7f), 0.0f, 0.0f, 1.0f);
                child.translateObject(tempCenterPoint.x, tempCenterPoint.y,
                        tempCenterPoint.z);
            }
        }
        if (window.getMouseInput().isLeftButtonPressed()){
            boolean check = true;
            Vector2f pos = window.getMouseInput().getCurrentPos();
            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);
            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);

            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1) && (pos.x != 0.0 && pos.y != 0.0))) {
                System.out.println("x : "+pos.x+" y : "+pos.y);
            }
        }
    }

    //    public void input(){
//        ArrayList<Object2d> tempCirlce = new ArrayList<>();
//        if (window.isKeyPressed(GLFW_KEY_W)){
//            System.out.println("W");
//        }
//        if (window.getMouseInput().isLeftButtonPressed()){
//            boolean check = true;
//            Vector2f pos = window.getMouseInput().getCurrentPos();
//            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);
//            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);
//
//            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1) && (pos.x != 0.0 && pos.y != 0.0))) {
////                System.out.println("x : "+pos.x+" y : "+pos.y);
//                if(objectsCircle.isEmpty()) {
//                    objectsPointsControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
//                    objectsCircle.add(new Circle(
//                            Arrays.asList(
//                                    new ShaderProgram.ShaderModuleData
//                                            ("resources/shaders/scene.vert"
//                                                    , GL_VERTEX_SHADER),
//                                    new ShaderProgram.ShaderModuleData
//                                            ("resources/shaders/scene.frag"
//                                                    , GL_FRAGMENT_SHADER)
//                            ),
//                            new ArrayList<>(),
//                            new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                            pos.x, pos.y, 0.1f, 0.1f, 45.0f
//                    ));
//                    tempPos.add(new Vector2f(pos));
//                    System.out.println(objectsCircle.size());
//                    objectsCurve.get(0).addVerticesCurve(new Vector3f(pos.x, pos.y, 0));
//                } else {
//                    for (int i = 0; i < objectsCircle.size();i++) {
//                        if((Math.sqrt((Math.pow((pos.x - tempPos.get(i).x), 2) +
//                                (Math.pow((pos.y - tempPos.get(i).y), 2))))) <= 0.07f) {
//                            tempCirlce.add(objectsCircle.get(i));
//                        }
//                    }
//                    for (int i = 0; i < objectsCircle.size(); i++) {
//                        if((Math.sqrt((Math.pow((pos.x - tempPos.get(i).x), 2) +
//                                (Math.pow((pos.y - tempPos.get(i).y), 2))))) <= 0.07f) {
//                            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1) && (pos.x != 0.0 && pos.y != 0.0))
//                                    && objectsCircle.get(i) == tempCirlce.get(0)) {
//                                objectsCircle.set(i, new Circle(
//                                        Arrays.asList(
//                                                new ShaderProgram.ShaderModuleData
//                                                        ("resources/shaders/scene.vert"
//                                                                , GL_VERTEX_SHADER),
//                                                new ShaderProgram.ShaderModuleData
//                                                        ("resources/shaders/scene.frag"
//                                                                , GL_FRAGMENT_SHADER)
//                                        ),
//                                        new ArrayList<>(),
//                                        new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                                        pos.x, pos.y, 0.1f, 0.1f, 45.0f
//                                ));
//                                tempPos.set(i, new Vector2f(pos));
//                                objectsPointsControl.get(0).setVertices(i, new Vector3f(pos.x, pos.y, 0.0f));
//                                objectsCurve.get(0).setVerticesCurve(i, new Vector3f(pos.x, pos.y, 0.0f));
//                                check = false;
//
//                            }
//                        } else if ((Math.sqrt((Math.pow((pos.x - tempPos.get(i).x), 2) +
//                                (Math.pow((pos.y - tempPos.get(i).y), 2))))) <= 0.15f) {
//                            check = false;
//                        }
//                    }
//
////                System.out.println(objectsCurve.get(0).createBezier(objectsCurve.get(0).getVertices().size(), objectsCurve.get(0).getVertices()));
//                    if (check) {
//                        objectsPointsControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
//                        objectsCircle.add(new Circle(
//                                Arrays.asList(
//                                        new ShaderProgram.ShaderModuleData
//                                                ("resources/shaders/scene.vert"
//                                                        , GL_VERTEX_SHADER),
//                                        new ShaderProgram.ShaderModuleData
//                                                ("resources/shaders/scene.frag"
//                                                        , GL_FRAGMENT_SHADER)
//                                ),
//                                new ArrayList<>(),
//                                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                                pos.x, pos.y, 0.1f, 0.1f, 45.0f
//                        ));
//                        tempPos.add(new Vector2f(pos));
//                        objectsCurve.get(0).addVerticesCurve(new Vector3f(pos.x, pos.y, 0));
//                    }
//                }
//            }
//        }
//    }
    public void run() {

        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Main().run();
    }
}