/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package avl_tree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class AVL_Tree {

    ArrayList<Student_info> fileList = new ArrayList<Student_info>();

    public ArrayList<Student_info> loadFile() {
        int studentCode;
        String name;
        String gender;
        int gpa;

        try {
            File file = new File("data_AVL.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] arrData = data.split(" ", 4);
                studentCode = Integer.parseInt(arrData[0]);
                name = arrData[1];
                gender = arrData[2];
                gpa = Integer.parseInt(arrData[3]);
                fileList.add(new Student_info(studentCode, name, gender, gpa));
            }
        } catch (Exception e) {
            System.out.println("There aren't any Files");
        }
        return fileList;
    }

    public void writeFile(ArrayList fileList) {
        try {
            File file = new File("data_AVL.txt");
            if (!file.exists()) { // if file doesnt exists, then create it
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < fileList.size(); i++) {
                bw.write(fileList.get(i).toString() + "\n");
            }
            System.out.println("Changes have been saved successfully!");
            bw.close();
        } catch (Exception e) {
            System.out.println("The File is empty.");
        }
    }

    public void Menu() {
        int choose;
        Scanner sc = new Scanner(System.in);
        AVL_Tree file = new AVL_Tree();
        Trees tree = new Trees(file.loadFile());
        for (int i = 0; i < tree.fileList.size(); i++) {
            tree.insert(tree.fileList.get(i));
        }
        System.out.println("Load file success!");
        System.out.println("File:");
        for (int i = 0; i < tree.fileList.size(); i++) {
            System.out.println(tree.fileList.get(i));
        }
        System.out.println("");
        boolean change = true; //to check save file
        do {
            System.out.println("1. Insert(Student_info).");
            System.out.println("2. Search(int student_code).");
            System.out.println("3. Delete_by_merging(int student_code).");
            System.out.println("4. Delete_by_copying(int student_code).");
            System.out.println("5. Write_data(filepath).");
            System.out.println("Others - Quit.");
            System.out.print("Please enter your choice: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("Input Student code: ");
                    int stCode = sc.nextInt();
                    System.out.print("Input Student name: ");
                    String stName = sc.next();
                    System.out.print("Input Student gender: ");
                    String gender = sc.next();
                    System.out.print("Input Student gpa: ");
                    int gpa = sc.nextInt();
                    
                    tree.fileList.add(new Student_info(stCode, stName, gender, gpa));//Add vô list để save
                    tree.insert(new Student_info(stCode, stName, gender, gpa));//Insert vô cây AVL
                    System.out.println("Insert success!");
                    System.out.println("");
                    tree.inOrder(tree.root);//Print ra check
                    System.out.println("");
                    break;
                case 2:
                    System.out.print("Input Student Code for searching: ");
                    System.out.println(tree.search(tree.root, sc.nextInt()).info);
                    System.out.println("");
                    break;
                case 3:
                    System.out.print("Input Student Code for deleting: ");
                    int delCode = sc.nextInt();
                    tree.deleteByMerging(delCode);
                    for (int i = 0; i < tree.fileList.size(); i++) {
                        if (tree.fileList.get(i).getStudent_code() == delCode) { //Nếu == student code cần xóa thì xóa
                            tree.fileList.remove(i);
                        }
                    }
                    System.out.println("Delete success!");
                    System.out.println("");
                    tree.inOrder(tree.root);
                    System.out.println("");
                    break;
                case 4:
                    System.out.print("Input Student Code for deleting: ");
                    int delStCode = sc.nextInt();
                    tree.deleteByCopy(delStCode);
                    for (int i = 0; i < tree.fileList.size(); i++) {
                        if (tree.fileList.get(i).getStudent_code() == delStCode) { //Nếu == student code cần xóa thì xóa
                            tree.fileList.remove(i);
                        }
                    }
                    System.out.println("Delete success!");
                    System.out.println("");
                    tree.inOrder(tree.root);
                    System.out.println("");
                    break;
                case 5:
                    file.writeFile(tree.fileList);
                    change = false;
                    System.out.println("Write success!");
                    System.out.println("");
                    for (int i = 0; i < tree.fileList.size(); i++) {
                        System.out.println(tree.fileList.get(i));
                    }
                    System.out.println("");
                    break;
                default:
                    if (change == true) {
                        System.out.print("Save file?(Y/N): ");
                        String ans = "";
                        boolean check = true;
                        Scanner scan = new Scanner(System.in);
                        do {
                            ans = scan.nextLine().toUpperCase();
                            if (ans.equals("Y")) {
                                file.writeFile(tree.fileList);
                                System.out.print("Save Successfully!");
                            } else if (ans.equals("N")) {
                                System.out.print("Save Fail. Good Bye!");
                            } else {
                                check = false;
                            }
                        } while (check == false);
                    } else {
                        System.out.println("Good Bye!");
                    }
            }
        } while (choose >= 1 && choose <= 5);
    }

    public static void main(String[] args) {
        AVL_Tree menu = new AVL_Tree();
        menu.Menu();
    }
}
