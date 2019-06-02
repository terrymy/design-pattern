package com.design.action.visitor;

public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}
