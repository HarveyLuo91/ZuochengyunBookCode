package PinDuoDuo.wuqi;


import java.util.*;

class Tree{
    public Tree(){
        parent=-1;
        nodes=new ArrayList<Tree>();
    }
    int parent;
    public String name;
    public List<Tree> nodes;
}

public class Main2 {

    public static void main(String[] args) {
        HashMap<Integer,Tree> hashMap=new HashMap<Integer,Tree>();
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for (int i=0;i<n;i++){
            String name_temp=scanner.next();
            int pa=scanner.nextInt();
            Tree treeTemp=new Tree();
            treeTemp.name=name_temp;
            treeTemp.parent=pa;
            hashMap.put(i,treeTemp);
        }
        Tree root=null;
        for (int i=0;i<n;i++){
            int pa=hashMap.get(i).parent;
            if (pa!=-1){
                hashMap.get(pa).nodes.add(hashMap.get(i));
            }else{
                root=hashMap.get(i);
            }
        }

        show(root,-1,true,true);

    }
    public static void sort(Tree root){
        if (root.nodes.size()>0){
            root.nodes.sort(new Comparator<Tree>() {
                @Override
                public int compare(Tree o1, Tree o2) {
                    return 0;
                }
            });
        }
    }
    public static void show(Tree root,int level,boolean last,boolean paLast){
        if (root.name!=null){
            if (level<0){
                System.out.println(root.name);
            }else{
                for (int i=0;i<=level-1;i++){

                    if (i==level-1&&level>1){
                        if (!paLast){
                            System.out.print("|   ");
                        }else{
                            System.out.print("    ");
                        }
                    }else{
                        System.out.print("   ");
                    }
                }

                if (last==false){
                    System.out.println("|-- "+root.name);
                }else{
                    System.out.println("`-- "+root.name);
                }
            }
            if (root.nodes.size()>0){
                for (int i=0;i<root.nodes.size();i++){
                    if (i!=root.nodes.size()-1){
                        show(root.nodes.get(i),level+1,false,last);
                    }else{
                        show(root.nodes.get(i),level+1,true,last);
                    }
                }
            }
        }
    }

}
