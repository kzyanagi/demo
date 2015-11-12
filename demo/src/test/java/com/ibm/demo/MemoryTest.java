package com.ibm.demo;


import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;


/**
 * ArrayList,FileListSingleImpl,FileListMultipleImplを使ったテスト
 *
 * オブジェクトセット→オブジェクトゲット→コンソールへプリントアウトの順
 *
 * @author
 * @version 1.0
 */

public class MemoryTest extends TestCase{

	private String path = "tmp";
	private int getdataroop =50;
	private int outputroop =500;

	/**
	 * ArrayListを利用したロジックのテスト
	 *
	 * ArrayListを利用した場合の速さを確認するため、用意したテストケース。
	 * ArrayListにオブジェクトをセットして、コンソールへ出力する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */

	@Test
	//ArrayListを利用したロジックのテスト
	public void test_OutPutTestOfArrayList(){

	    // 出力用DTO
	    ArrayList<TestBean> A8060DTO = new ArrayList<TestBean>();

	    //データ取得
		A8060DTO = GetData_ArrayList();

    	//出力
   		output_ArrayList(A8060DTO);
	}


	/**
	 * オブジェクトをArrayListへaddする
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	private ArrayList<TestBean> GetData_ArrayList() {
        StringBuffer str = new StringBuffer();
        for(int i=0;i < getdataroop ; i++){
        	str.append("AAAAAAAAAAAAA");
        }

        int maxcount = outputroop;
        ArrayList<TestBean> alDTO = new ArrayList<TestBean>();
		for(int i = 0;i<maxcount ; i++){
			TestBean svfDTO = new TestBean(("No" + i).toString(),("DATA"+ i).toString());
			alDTO.add(svfDTO);
		}
		return alDTO;
	}

	/**
	 * オブジェクトをArrayListからゲットしてコンソールへ出力する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	private void output_ArrayList(ArrayList<TestBean> a8060dto) {
		for (TestBean svfDTO : a8060dto)
		{
			System.out.println(svfDTO.getAa());
			//System.out.println(svfDTO.getBb());
		}
	}

	/**
	 * FileListSingleImplを利用したロジックのテスト
	 *
	 * FileListSingleImplを利用した場合の速さを確認するため、用意したテストケース。
	 * FileListSingleImplにオブジェクトをセットして、コンソールへ出力する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	@Test
	//FileListSingleImplを利用したロジックのテスト
	public void test_OutPutTestOfFileListSingleImpl(){

	    // 出力用DTO
	    List<TestBean> A8060DTO = new FileListSingleImpl<TestBean>(path);

	    //データ取得
		A8060DTO = GetData_FileListSingleImpl();

    	//出力
   		output_FileListSingleImpl(A8060DTO);

   		A8060DTO.clear();
	}

	/**
	 * オブジェクトをFileListSingleImplへaddする
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	private List<TestBean> GetData_FileListSingleImpl() {
        StringBuffer str = new StringBuffer();
        for(int i=0;i < getdataroop ; i++){
        	str.append("AAAAAAAAAAAAA");
        }

        int maxcount = outputroop;
        List<TestBean> alDTO_test = new FileListSingleImpl<TestBean>(path);
		for(int i = 0;i<maxcount ; i++){
			TestBean svfDTO = new TestBean(("No" + i).toString(),("DATA"+ i).toString());
			alDTO_test.add(svfDTO);
		}
		return alDTO_test;
	}

	/**
	 * オブジェクトをFileListSingleImplからゲットしてコンソールへ出力する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	private void output_FileListSingleImpl(List<TestBean> a8060dto) {
		for (TestBean svfDTO : a8060dto)
		{
			System.out.println(svfDTO.getAa());
			//System.out.println(svfDTO.getBb());
		}
		//ファイル削除
		a8060dto.clear();

	}

	/**
	 * FileListMultipleImplを利用したロジックのテスト
	 *
	 * FileListMultipleImplを利用した場合の速さを確認するため、用意したテストケース。
	 * FileListMultipleImplにオブジェクトをセットして、コンソールへ出力する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */

	@Test
	//FileListMultipleImplを利用したロジックのテスト
	public void test_OutPutTestOfFileListMultipleImpl(){

	    // 出力用DTO
	    List<TestBean> A8060DTO = new FileListMultipleImpl<TestBean>(path);

	    //データ取得
		A8060DTO = GetData_FileListMultipleImpl();

    	//出力
   		output_FileListMultipleImpl(A8060DTO);
   		A8060DTO.clear();
	}

	/**
	 * オブジェクトをFileListMultipleImplへaddする
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	private List<TestBean> GetData_FileListMultipleImpl() {
        StringBuffer str = new StringBuffer();
        for(int i=0;i < getdataroop ; i++){
        	str.append("AAAAAAAAAAAAA");
        }

        int maxcount = outputroop;
        List<TestBean> alDTO_test = new FileListMultipleImpl<TestBean>(path);
		for(int i = 0;i<maxcount ; i++){
			TestBean svfDTO = new TestBean(("No" + i).toString(),("DATA"+ i).toString());
			alDTO_test.add(svfDTO);
		}
		return alDTO_test;
	}

	/**
	 * オブジェクトをFileListMultipleImplからゲットしてコンソールへ出力する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	private void output_FileListMultipleImpl(List<TestBean> a8060dto) {
		for (TestBean svfDTO : a8060dto)
		{
			System.out.println(svfDTO.getAa());
			//System.out.println(svfDTO.getBb());
		}
		//ファイル削除
		a8060dto.clear();

	}

	/**
	 * ListFactoryを利用したロジックのテスト
	 *
	 * ListFactoryを利用した場合のテストケース。
	 * ListFactoryを経由して、FileListSimpleImpl、FileListMultipleImplのどちらかを利用して、コンソールへ出力する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */

	@Test
	//FileListMultipleImplを利用したロジックのテスト
	public void test_OutPutTestOfListFactory(){

	    // 出力用DTO
		List<TestBean> A8060DTO = null;

	    //データ取得
		A8060DTO = GetData_ListFactory();

    	//出力
		output_ListFactory(A8060DTO);
	}

	/**
	 * オブジェクトをListFactoryへaddする
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	private List<TestBean> GetData_ListFactory() {
        StringBuffer str = new StringBuffer();
        for(int i=0;i < getdataroop ; i++){
        	str.append("AAAAAAAAAAAAA");
        }

        int maxcount = outputroop;

        List<TestBean> alDTO_test = null;
		ListFactory<TestBean> lf = new ListFactory<TestBean>();
		alDTO_test = lf.createList();

		for(int i = 0;i<maxcount ; i++){
			TestBean svfDTO = new TestBean(("No" + i).toString(),("DATA"+ i).toString());
			alDTO_test.add(svfDTO);
		}
		return alDTO_test;
	}

	/**
	 * オブジェクトをListFactoryからゲットしてコンソールへ出力する。
	 *
	 * @param
	 *
	 * @return
	 * @throws
	 */
	private void output_ListFactory(List<TestBean> a8060dto) {
		for (TestBean svfDTO : a8060dto)
		{
			System.out.println(svfDTO.getAa());
			//System.out.println(svfDTO.getBb());
		}
		//ファイル削除
		a8060dto.clear();

	}


}