#version 330
layout (location=0) in vec3 position;
uniform mat4 model;
uniform mat4 view;
uniform mat4 projection;
void main()
{
    //vec4(position,alpha)
    gl_Position = projection * view * model * vec4(position, 1.0); //harus model dl krn komp baca dri kanan, disni dgn yg d inet psti kebalik
}