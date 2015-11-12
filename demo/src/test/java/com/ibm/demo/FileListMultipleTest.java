package com.ibm.demo;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;



/**
 * FileListMultipleImplクラスのテスト
 *
 * @author
 * @version 1.0
 */

public class FileListMultipleTest extends TestCase{

	private String path = "tmp\\";

	/**
	 * add(E arg0)のテスト--投入したオブジェクトがFileListSingleImplに、addされることを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//add(E arg0)のテスト
	public void test_add_1(){
		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);
		TestBean tb1 = new TestBean("test1","test111");

		lst.add(tb1);

		assertEquals("test1", lst.get(0).getAa());

		lst.clear();
	}

	/**
	 * add(int arg0, E arg1)のテスト--投入したオブジェクトがFileListSingleImplに、addされることを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//add(int arg0, E arg1)のテスト
	public void test_add_2(){
		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);
		TestBean tb1 = new TestBean("test1","test111");
		TestBean tb2 = new TestBean("test2","test222");
		TestBean tb3 = new TestBean("test3","test333");
		TestBean tb4 = new TestBean("test4","test444");

		lst.add(tb1);
		lst.add(tb2);
		lst.add(tb3);
		lst.add(1,tb4);

		for (TestBean svfDTO : lst){

			System.out.print(svfDTO.getAa());
			System.out.print(":");
			System.out.println(svfDTO.getBb());
		}

		lst.clear();
	}
	/**
	 * addAll(Collection< extends E> arg0)のテスト--オブジェクトが実装されていないことを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//addAll(Collection<? extends E> arg0)のテスト
	public void test_addAll_1(){
		List<TestBean> lst = new ArrayList<TestBean>();
		TestBean tb1 = new TestBean("test1","test111");
		TestBean tb2 = new TestBean("test2","test222");
		TestBean tb3 = new TestBean("test3","test333");
		TestBean tb4 = new TestBean("test4","test444");
		TestBean tb5 = new TestBean("test5","test555");
		TestBean tb6 = new TestBean("test6","test666");

		lst.add(tb1);
		lst.add(tb2);
		lst.add(tb3);
		lst.add(tb4);

		List<TestBean> lst2 = new FileListMultipleImpl<TestBean>(path);
		lst2.add(tb5);
		lst2.add(tb6);

		try{
			lst2.addAll(lst);
		}catch(UnsupportedOperationException e){
			assertEquals("メソッドaddAll(Collection<? extends E> arg0)は実装されていません。", e.getMessage());
		}
		lst.clear();
		lst2.clear();
	}
	/**
	 * addAll(int arg0, Collection< extends E> arg1)のテスト--オブジェクトが実装されていないことを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//addAll(int arg0, Collection<? extends E> arg1)のテスト
	public void test_addAll_2(){
		List<TestBean> lst = new ArrayList<TestBean>();
		TestBean tb1 = new TestBean("test1","test111");
		TestBean tb2 = new TestBean("test2","test222");
		TestBean tb3 = new TestBean("test3","test333");
		TestBean tb4 = new TestBean("test4","test444");
		TestBean tb5 = new TestBean("test5","test555");
		TestBean tb6 = new TestBean("test6","test666");

		lst.add(tb1);
		lst.add(tb2);
		lst.add(tb3);
		lst.add(tb4);

		List<TestBean> lst2 = new FileListMultipleImpl<TestBean>(path);
		lst2.add(tb5);
		lst2.add(tb6);

		try{
			lst2.addAll(0,lst);
		}catch(UnsupportedOperationException e){
			assertEquals("メソッドaddAll(int arg0, Collection<? extends E> arg1)は実装されていません。", e.getMessage());
		}
		lst.clear();
		lst2.clear();
	}

	/**
	 * contains(Object arg0)のテスト--オブジェクトが実装されていないことを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//contains(Object arg0)のテスト
	public void test_contains(){
		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);

		TestBean tb1 = new TestBean("test1","test111");

		lst.add(tb1);

		try{
			lst.contains(tb1);
		}catch(UnsupportedOperationException e){
			assertEquals("メソッドcontains(Object arg0)は実装されていません。", e.getMessage());
		}finally{
			lst.clear();
		}

	}
	/**
	 * containsAll(Collection<> arg0)のテスト--オブジェクトが実装されていないことを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//containsAll(Collection<?> arg0)のテスト
	public void test_containsAll(){
		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);

		TestBean tb1 = new TestBean("test1","test111");
		TestBean tb2 = new TestBean("test2","test222");

		lst.add(tb1);
		lst.add(tb2);

		try{
			lst.containsAll(lst);
		}catch(UnsupportedOperationException e){
			assertEquals("メソッドcontainsAll(Collection<?> arg0)は実装されていません。", e.getMessage());
		}finally{
			lst.clear();
		}

	}

	/**
	 * get(int arg0)のテスト-- FileListSingleImplからオブジェクトを取得できること。
	 * また、インデックスが範囲外の場合は、IndexOutOfBoundsExceptionが発生することの確認。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//get(int arg0)のテスト
	public void test_get(){
		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);

		TestBean tb1 = new TestBean("test1","test111");
		TestBean tb2 = new TestBean("test2","test222");

		lst.add(tb1);
		lst.add(tb2);

		assertEquals("test1",lst.get(0).getAa());

		try{
			lst.get(2);
		}catch(IndexOutOfBoundsException e){
			assertEquals("インデックスが範囲外です", e.getMessage());
		}

		lst.clear();
	}

	/**
	 * indexOf(Object arg0)のテスト--オブジェクトが実装されていないことを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//indexOf(Object arg0)のテスト
	public void test_indexOf(){
		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);

		TestBean tb1 = new TestBean("test1","test111");
		TestBean tb2 = new TestBean("test2","test222");

		lst.add(tb1);
		lst.add(tb2);
		try{
			lst.indexOf(tb1);
		}catch(UnsupportedOperationException e){
			assertEquals("メソッドindexOf(Object arg0)は実装されていません。",e.getMessage());
		}finally{
			lst.clear();
		}
	}
	/**
	 * isEmpty()のテスト--オブジェクトが実装されていないことを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */	@Test
	//isEmpty()のテスト
	public void test_isEmpty(){
		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);

		assertEquals(true,lst.isEmpty());

		TestBean tb1 = new TestBean("test1","test111");
		lst.add(tb1);

		assertEquals(false,lst.isEmpty());

		lst.clear();
	}
	/**
	 * iterator()のテスト--ループ処理が実行され、正しくオブジェクトが取得できることを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//iterator()のテスト
	public void test_iterator(){
		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);

		TestBean tb1 = new TestBean("test1","test111");
		TestBean tb2 = new TestBean("test2","test222");

		lst.add(tb1);
		lst.add(tb2);

		Iterator<TestBean> itr = ((FileListMultipleImpl)lst).iterator();
		int cnt = 1;
		while(itr.hasNext()){
			TestBean tbResult = (TestBean) itr.next();
			assertEquals(("test" + cnt).toString(), tbResult.getAa().toString());
			cnt ++;
		}

		lst.clear();
	}
	/**
	 * lastIndexOf(Object arg0)のテスト--オブジェクトが実装されていないことを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//lastIndexOf(Object arg0)のテスト
	public void test_lastIndexOf(){
		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);

		TestBean tb1 = new TestBean("test1","test111");
		TestBean tb2 = new TestBean("test2","test222");

		lst.add(tb1);
		lst.add(tb2);
		try{
			lst.lastIndexOf(tb1);
		}catch(UnsupportedOperationException e){
			assertEquals("メソッドlastIndexOf(Object arg0)は実装されていません。",e.getMessage());
		}finally{
			lst.clear();
		}
	}
	/**
	 * remove(Object arg0)のテスト--オブジェクトが実装されていないことを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//remove(Object arg0)のテスト
	public void test_remove_1(){
		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);

		TestBean tb1 = new TestBean("test1","test111");
		TestBean tb2 = new TestBean("test2","test222");

		lst.add(tb1);
		lst.add(tb2);
		try{
			lst.remove(tb1);
		}catch(UnsupportedOperationException e){
			assertEquals("メソッドremove(Object arg0)は実装されていません。",e.getMessage());
		}finally{
			lst.clear();
		}
	}
	/**
	 * remove(int index)のテスト-- FileListSingleImplから指定indexのオブジェクトが削除できること。また、指定された位置に以前あった要素 が戻ることを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//remove(int index)のテスト
	public void test_remove_2(){
		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);

		TestBean tb1 = new TestBean("test1","test111");
		TestBean tb2 = new TestBean("test2","test222");
		TestBean tb3 = new TestBean("test3","test333");

		lst.add(tb1);
		lst.add(tb2);
		lst.add(tb3);

		assertEquals("test2",lst.remove(1).getAa());
		assertEquals("test3", lst.get(1).getAa());

		lst.clear();
	}

	/**
	 * removeAll(Collection<> arg0)のテスト--オブジェクトが実装されていないことを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//removeAll(Collection<?> arg0)のテスト
	public void test_removeAll(){
		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);

		List<TestBean> arylist = new ArrayList<TestBean>();

		TestBean tb1 = new TestBean("test1","test111");
		TestBean tb2 = new TestBean("test2","test222");

		arylist.add(tb1);
		arylist.add(tb2);

		try{
			lst.removeAll(arylist);
		}catch(UnsupportedOperationException e){
			assertEquals("メソッドremoveAll(Collection<?> arg0)は実装されていません。",e.getMessage());
		}
		lst.clear();
	}

	/**
	 * size()のテスト--リスト内に保存されている数が戻ることを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//size()のテスト
	public void test_size(){
		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);

		TestBean tb1 = new TestBean("test1","test111");
		TestBean tb2 = new TestBean("test2","test222");

		lst.add(tb1);
		lst.add(tb2);

		assertEquals(2,lst.size());

		lst.clear();
	}

	/**
	 * NULLをaddしたときのテスト-- NULLがaddされた場合、NullPointerExceptionが発生することを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//NULLをaddしたときのテスト
	public void test_add_null(){

		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);
		try{
			lst.add(null);
		}catch(NullPointerException e){
			assertEquals("nullはaddできません。",e.getMessage());
		}

		List<TestBean> lst2 = new ArrayList<TestBean>();
		try{
			lst2.add(null);
			lst2.get(0).getAa();
		}catch(NullPointerException e){
			assertEquals(null,e.getMessage());
		}

		lst.clear();
		lst2.clear();
	}
	/**
	 * キャストができるかどうかのテスト--オブジェクトのキャストをした場合、ClassCastExceptionが発生することを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//キャストができるかどうかのテスト
	public void test_add_CAST(){
		List lst = null;
		List lst2 = null;
		TestBean tb1 = new TestBean("test1","test111");
		TestBean2 tb2 = new TestBean2("test2","test222");

		try{
			lst = new FileListMultipleImpl(path);
			lst.add(tb2);
			TestBean result_bean1 =(TestBean)lst.get(0);
		}catch(ClassCastException e){
//			assertEquals("com.ibm.TestBean2 cannot be cast to com.ibm.TestBean", e.getMessage());
		}
		try{
			lst2 = new ArrayList();
			lst2.add(tb2);
			TestBean result_bean2 = (TestBean)lst2.get(0);
		}catch(ClassCastException e){
//			assertEquals("com.ibm.TestBean2 cannot be cast to com.ibm.TestBean", e.getMessage());
		}


		lst.clear();
		lst2.clear();
	}

	/**
	 * シリアライズされていないオブジェクトをaddした場合のテスト--シリアライズされていないオブジェクトを追加した場合、IllegalArgumentExceptionが発生することを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//シリアライズされていないオブジェクトをaddした場合のテスト
	public void test_add_NoSerializable(){
		TestBean3 tb3 = new TestBean3("test2","test222");


		List<TestBean3> lst = new FileListMultipleImpl<TestBean3>(path);
		try{
		lst.add(tb3);
		TestBean3 result_bean1 =(TestBean3)lst.get(0);
		assertEquals("test2", result_bean1.getAa());
		}catch(IllegalArgumentException e){
			assertEquals("Serializableされていないオブジェクトは追加できません。", e.getMessage());
		}


		List<TestBean3> lst2 = new ArrayList<TestBean3>();
		lst2.add(tb3);
		TestBean3 result_bean2 = (TestBean3)lst2.get(0);
		assertEquals("test2", result_bean2.getAa());

		lst.clear();
		lst2.clear();
	}
	/**
	 * オブジェクト出力先パスのテスト-- FileListSingleImplのコンストラクタに、出力先パスを設定した場合、指定したパスに、出力されていることを確認。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//オブジェクト出力先パスのテスト
	public void test_add_FilePath(){
		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);

		TestBean tb = new TestBean("test1","test111");

		lst.add(tb);

		lst.clear();


	}
	/**
	 * clear()のテスト--追加したオブジェクトが、リストから削除されることを確認
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//clear()のテスト
	public void test_clear(){
		List<TestBean> lst = new FileListMultipleImpl<TestBean>(path);

		TestBean tb1 = new TestBean("test1","test111");
		TestBean tb2 = new TestBean("test2","test222");

		lst.add(tb1);
		lst.add(tb2);

		assertEquals(2, lst.size());
		lst.clear();
		assertEquals(0, lst.size());


	}
	/**
	 * Stringでのテスト--Stringオブジェクトでもリストに追加され、さらに、ゲットされることを確認する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//Stringでのテスト
	public void test_StringTest(){
		List<String> lst = new FileListMultipleImpl<String>(path);

		lst.add("test1");

		assertEquals("test1", lst.get(0).toString());

		lst.clear();
	}



}


