package com.vlocker.ui.graphic;

import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;

public class LShapeHolder {
    private float alpha = 1.0f;
    private int color;
    private RadialGradient gradient;
    private float mOriginalX = 0.0f;
    private float mOriginalY = 0.0f;
    private Paint paint;
    private ShapeDrawable shape;
    private float x = 0.0f;
    private float y = 0.0f;

    public LShapeHolder(ShapeDrawable shapeDrawable) {
        this.shape = shapeDrawable;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public int getColor() {
        return this.color;
    }

    public RadialGradient getGradient() {
        return this.gradient;
    }

    public float getHeight() {
        return this.shape.getShape().getHeight();
    }

    public Paint getPaint() {
        return this.paint;
    }

    public ShapeDrawable getShape() {
        return this.shape;
    }

    public float getWidth() {
        return this.shape.getShape().getWidth();
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getmOriginalX() {
        return this.mOriginalX;
    }

    public float getmOriginalY() {
        return this.mOriginalY;
    }

    public void setAlpha(float f) {
        this.alpha = f;
        this.shape.setAlpha((int) ((255.0f * f) + 0.5f));
    }

    public void setColor(int i) {
        this.shape.getPaint().setColor(i);
        this.color = i;
    }

    public void setGradient(RadialGradient radialGradient) {
        this.gradient = radialGradient;
    }

    public void setHeight(float f) {
        Shape shape = this.shape.getShape();
        shape.resize(shape.getWidth(), f);
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public void setShape(ShapeDrawable shapeDrawable) {
        this.shape = shapeDrawable;
    }

    public void setWidth(float f) {
        Shape shape = this.shape.getShape();
        shape.resize(f, shape.getHeight());
    }

    public void setX(float f) {
        this.x = f;
    }

    public void setY(float f) {
        this.y = f;
    }

    public void setmOriginalX(float f) {
        this.mOriginalX = f;
    }

    public void setmOriginalY(float f) {
        this.mOriginalY = f;
    }
}
