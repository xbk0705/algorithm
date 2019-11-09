package com.xiabaike.algo.main;

import com.xiabaike.algo.datastructrue.ChainListType;

public class ChainListTypeMain {

	public static void main(String[] args) {
		ChainListType head = new ChainListType();
		head.getData().setKey("001");
		head.getData().setName("A");
		head.getData().setAge(11);
		ChainListType second = new ChainListType();
		head.setNextNode(second);
		second.getData().setKey("002");
		second.getData().setName("B");
		second.getData().setAge(12);
		ChainListType third = new ChainListType();
		second.setNextNode(third);
		third.getData().setKey("003");
		third.getData().setName("C");
		third.getData().setAge(13);
		ChainListType fourth = new ChainListType();
		third.setNextNode(fourth);
		fourth.getData().setKey("004");
		fourth.getData().setName("D");
		fourth.getData().setAge(14);
		fourth.setNextNode(null);
		
		System.out.println(head.length(head));
	}
	
}
