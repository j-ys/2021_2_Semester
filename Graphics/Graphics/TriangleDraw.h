#pragma once
#include <GL/glut.h>

void displayTriangle()
{

    // Set every pixel in the frame buffer to the current clear color.
    glClear(GL_COLOR_BUFFER_BIT);

    // Drawing is done by specifying a sequzence of vertices.  The way these
    // vertices are connected (or not connected) depends on the argument to
    // glBegin.  GL_POLYGON constructs a filled polygon.
    glBegin(GL_POLYGON);

    glColor3f(1, 1, 1);
    glVertex3f(-0.6, -0.75, 0.0);
    glColor3f(0, 0, 0);
    glVertex3f(0.6, -0.75, 0);
    glColor3f(1, 0, 1);
    glVertex3f(1, 0, 0);
    glColor3f(0, 0, 1);
    glVertex3f(0, 0.75, 0);
    glColor3f(0, 1, 1);
    glVertex3f(-1, 0, 0);

    glEnd();

    glFlush();
}