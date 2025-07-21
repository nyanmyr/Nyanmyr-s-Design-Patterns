package composite;

import java.util.ArrayList;
import java.util.List;

interface Department {

    void showDepartmentDetails(int indent);

    default String getIndentation(int indent) {
        return " ".repeat(indent * 2); // 2 spaces per level
    }
}

class SalesDepartment implements Department {

    String id;

    public SalesDepartment(String id) {
        this.id = id;
    }

    @Override
    public void showDepartmentDetails(int indent) {
        System.out.printf((getIndentation(indent)) + "%s Sales Department\n", id);
    }
}

class HRDepartment implements Department {

    String id;

    public HRDepartment(String id) {
        this.id = id;
    }

    @Override
    public void showDepartmentDetails(int indent) {
        System.out.printf((getIndentation(indent)) + "%s HR Department\n", id);
    }
}

class HeadDepartment implements Department {

    String id;
    public final List<Department> childDepartments = new ArrayList<>();

    public HeadDepartment(String id) {
        this.id = id;
    }

    @Override
    public void showDepartmentDetails(int indent) {
        System.out.printf((getIndentation(indent)) + "%s Head Department\n", id);
        for (Department dept : childDepartments) {
            dept.showDepartmentDetails(indent + 1);
        }
    }

    public void addDepartment(Department dept) {

        childDepartments.add(dept);
    }

    public void removeDepartment(Department dept) {

        childDepartments.remove(dept);
    }

}

public class Composite {

    public static void main(String[] args) {

        // Departments creations
        var hd = new HeadDepartment("01");
        var hd2 = new HeadDepartment("02");
        var hd3 = new HeadDepartment("03");
        
        var sales = new SalesDepartment("001");
        var hr = new HRDepartment("001");
        
        
        System.out.println("Show The entire Hierarchy: ");
        hd.addDepartment(sales);
        hd2.addDepartment(hr);
        hd2.addDepartment(hd);
        hd2.addDepartment(hd);
        hd3.addDepartment(hd2);
        hd3.showDepartmentDetails(0);

        System.out.println();
        System.out.println("Show Specific Parts of the Hierarchy: ");
        hd3.childDepartments.get(0).showDepartmentDetails(0);
    }

}
