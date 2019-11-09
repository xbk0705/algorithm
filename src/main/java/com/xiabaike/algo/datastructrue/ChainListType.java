package com.xiabaike.algo.datastructrue;

/**
 * 链表结构
 */
public class ChainListType {

	private Data data = new Data();
	private ChainListType nextNode;
	
	/**
	 * 在尾部追加节点
	 */
	public ChainListType addLast(ChainListType head, Data data) {
		ChainListType node, htemp;
		node = new ChainListType();
		// 保存数据
		node.setData(data);
		//  设置节点引用为空，即为表尾
		node.setNextNode(null);
		if(head == null) {
			head = node;
		}else{
			htemp = head;
			// 查找尾节点
			while(htemp.getNextNode() != null) {
				htemp = htemp.getNextNode();
			}
			// 查找到尾节点，设置尾节点的 nextnode 为要插入的节点地址，即在尾部完成插入节点动作
			htemp.setNextNode(node);
		}
		return head;
	}
	
	/**
	 * 根据关键字查找节点
	 */
	public ChainListType find(ChainListType head, String key) {
		ChainListType node = head;
		// 从头结点开始逐节点查找
		while((node = node.getNextNode()) != null) {
			// 判断节点关键字是否与要查找的关键字相同
			if(node.getData().getKey().equals(key)) {
				// 返回该节点引用
				return node;
			}
		}
		return null;
	}
	
	/**
	 * 在链表头部插入节点
	 */
	public ChainListType addFirst(ChainListType head, Data data) {
		ChainListType node = new ChainListType();
		// 保存数据
		node.setData(data);
		// 指向头引用所指节点
		node.setNextNode(head);
		// 头引用指向新增节点
		head = node;
		return head;
	}
	
	/**
	 * 插入节点到指定位置
	 */
	public ChainListType insert(ChainListType head, String findkey, Data data) {
		ChainListType node = new ChainListType();
		// 保存数据
		node.setData(data);
		// 查找要插入的节点
		ChainListType findnode = find(head, findkey);
		if(findnode != null) {
			// 新插入的节点指向关键节点的下一节点
			node.setNextNode(findnode.getNextNode());
			// 关键节点的下一节点指向新插入的节点
			findnode.setNextNode(node);
		}else{
			System.err.println("未找到指定位置......");
		}
		return head;
	}
	
	/**
	 * 删除指定节点
	 */
	public ChainListType delete(ChainListType head, String findkey) {
		ChainListType node, htemp;
		htemp = head;
		node = head;
		while((node = node.getNextNode()) != null) {
			if(node.getData().getKey().equals(findkey)) {
				// 使上一节点指向当前节点的下一节点
				htemp.setNextNode(node.getNextNode());
				// 释放内存
				node = null;
				return head;
			}else{
				// 设置上一节点
				htemp.setNextNode(node);
			}
		}
		return head;
	}
	
	/**
	 * 计算链表长度
	 */
	public int length(ChainListType head) {
		int length = 0;
		ChainListType htemp = head;
		// 遍历整个链表
		while(htemp != null) {
			// 累加节点数量
			length++;
			htemp = htemp.getNextNode();
		}
		return length;
	}
	
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public ChainListType getNextNode() {
		return nextNode;
	}

	public void setNextNode(ChainListType nextNode) {
		this.nextNode = nextNode;
	}

	public class Data{
		private String key;
		private String name;
		private int age;
		
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return "Data [key=" + key + ", name=" + name + ", age=" + age + "]";
		}
	}
	
}
