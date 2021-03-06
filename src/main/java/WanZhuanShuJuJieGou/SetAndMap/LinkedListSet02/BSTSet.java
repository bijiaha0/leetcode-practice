package WanZhuanShuJuJieGou.SetAndMap.LinkedListSet02;

import WanZhuanShuJuJieGou.SetAndMap.MoreAboutMap08.FileOperation;
import WanZhuanShuJuJieGou.SetAndMap.TimeComplexityOfSet03.BST;
import WanZhuanShuJuJieGou.SetAndMap.TimeComplexityOfSet03.Set;

import java.util.ArrayList;

public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private WanZhuanShuJuJieGou.SetAndMap.TimeComplexityOfSet03.BST<E> bst;

    public BSTSet(){
        bst = new BST<>();
    }

    @Override
    public int getSize(){
        return bst.size();
    }

    @Override
    public boolean isEmpty(){
        return bst.isEmpty();
    }

    @Override
    public void add(E e){
        bst.add(e);
    }

    @Override
    public boolean contains(E e){
        return bst.contains(e);
    }

    @Override
    public void remove(E e){
        bst.remove(e);
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(WanZhuanShuJuJieGou.SetAndMap.MoreAboutMap08.FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            WanZhuanShuJuJieGou.SetAndMap.TimeComplexityOfSet03.BSTSet<String> set1 = new WanZhuanShuJuJieGou.SetAndMap.TimeComplexityOfSet03.BSTSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();

        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("a-tale-of-two-cities.txt", words2)){
            System.out.println("Total words: " + words2.size());

            WanZhuanShuJuJieGou.SetAndMap.TimeComplexityOfSet03.BSTSet<String> set2 = new WanZhuanShuJuJieGou.SetAndMap.TimeComplexityOfSet03.BSTSet<>();
            for(String word: words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}
