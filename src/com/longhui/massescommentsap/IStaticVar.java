package com.longhui.massescommentsap;

public interface IStaticVar {

	public static String HTTPURL = "http://192.168.8.174:8085/MassesComments/";
	
	public static String SHOPURL = "ShopInfoServlet?";

	public static String SELECTSIGNURL = "GetSignServlet";
	
	public static String SHOPLISTIMGURL = "http://192.168.8.174:8085/MassesComments/image/";
	
	public static String SIGNLISTIMGURL = "http://192.168.8.174:8085/MassesComments/sign/";
	
	public static String TUANURL = "GetShopInfoFilterTuanServlet?";
	
	public static String SIGNURL = "AddSignServlet";
	
	public static String SHOPDETAILURL = "GetShopDetaiServlet?";
	
	public static final String CACHE_DIR = "Bitmap";
	
	public static int[] LISTVIEWIMG = new int[] {
			R.drawable.ic_category_2147483648, R.drawable.ic_category_10,
			R.drawable.ic_category_20, R.drawable.ic_category_30,
			R.drawable.ic_category_45, R.drawable.ic_category_50,
			R.drawable.ic_category_55, R.drawable.ic_category_60,
			R.drawable.ic_category_65, R.drawable.ic_category_70,
			R.drawable.ic_category_80, R.drawable.ic_category_none };
	
	public static String[] LISTVIEWTXT = new String[] { "���ŷ���", "��ʳ", "����",
			"��������", "�˶�����", "����", "���", "�Ƶ�", "����", "����", "������", "��װ" };
	// �ڶ���listview���ı����
	public static String[][] MORELISTTXT = {
			{ "ȫ������", "С�Կ��", "������", "��ӰԺ", "KTV", "���", "���ư�Ħ", "����/�����",
					"����", "�����;Ƶ�", "����/����", "��԰", "����" },
			{ "ȫ����ʳ", "С�Կ��", "����", "���", "������", "����", "�ձ�", "������", "����",
					"��������", "�����", "�㽭��", "���ϲ�", "���", "�����ǲ�", "������", "³��",
					"������", "�ز�", "�½���", "����", "�����", "���ݲ�", "������", "����" },
			{ "ȫ������", "�ۺ��̳�", "����Ь��", "����/�����", "��ɫ����", "Ʒ���ۿ۵�", "�۾���", "�鱦��Ʒ",
					"��ױƷ", "�˶�����", "ʳƷ���", "���", "�����Ʒ", "ҩ��", "��ζ����", "���ӹ���",
					"����", "�Ҿ߽���", "��๺�ﳡ��" },
			{ "ȫ����������", "������", "KTV", "����/����", "��ӰԺ", "�ư�", "��԰", "��Ȫ", "�Ļ�����",
					"���ư�Ħ", "ϴԡ", "���", "��������", "����", "��ժ/ũ����", "������Ϸ", "̨���",
					"DIY�ֹ���", "�������", "����CS", "������", "��ſ��", "˽��ӰԺ", "�����������" },
			{ "ȫ���˶�����", "��������", "��Ӿ��", "�٤", "��ë���", "̨���", "�赸", "�����",
					"�߶��", "����", "��������", "����", "�������", "����", "ƹ�����",
					"��������˶�" },
			{ "ȫ������", "����", "����/SPA", "�ݿ�", "����", "��ױƷ", "�٤", "��������", "�赸",
					"����д��", "����" },
			{ "ȫ�����", "��ɴ��Ӱ", "����Ƶ�", "��ɴ���", "���칫˾", "�������", "����д��", "��ױ����",
					"����С��Ʒ", "�������", "�鳵����", "˾������", "�鷿װ��", "���������" },
			{ "ȫ���Ƶ�", "�����;Ƶ�", "���Ǽ��Ƶ�", "�ȼٴ�", "���Ǽ��Ƶ�", "���Ǽ��Ƶ�", "ũ��Ժ",
					"��Ԣʽ�Ƶ�", "��������", "��Ʒ�Ƶ�", "���Ƶ�ס��" },
			{ "ȫ������", "ά�ޱ���", "��У", "ͣ����", "4S��/������", "����վ", "���/����", "������",
					"����" },
			{ "ȫ������", "������Ӱ", "�׶����", "��������", "�в���", "���ӹ���", "������ӷ���" },
			{ "ȫ��������", "ҽԺ", "����", "�ݿ�", "����", "��ѵ", "����/��ӡ", "ѧУ", "������",
					"������վ", "��ϴ��", "����", "�ݳ�Ʒ����", "����¥", "С��", "���������" },
			{ "ȫ����װ", "�Ҿ߼�װ", "���õ���", "����", "��װ����", "װ�����" } };
	// shoplist��toplist�ı�
	public static String[] SHOPLIST_TOPLIST = new String[] { "ȫ���̻�", "�Ź��̻�",
			"��Ԥ���̻�", "��Ա���̻�", "�Ż�ȯ�̻�", "�����̻�" };
	// shoplist�������ı�
	public static String[] SHOPLIST_THREELIST = { "Ĭ������", "�������", "�������",
			"�������", "��ζ���", "��������", "�������", "�������", "�������" };
	// shoplist�������ı�
	public static String[] SHOPLIST_PLACE = new String[] { "����", "ȫ����������",
			"������", "������", "�ϸ���", "�㷻��", "ƽ����", "�ɱ���", "������", "��" };
	// ��ʳȫ����������2
	public static String[][] SHOPLIST_PLACESTREET = new String[][] {
			{ "500��", "1000��", "2000��", "5000��" },
			{ "ȫ������", "������", "������", "����", "������", "���ս�", "��������", "«�ҽ�/���",
					"����·", "ѧ��·", "�����·", "���½�", "���Ͼ���", "�ϼ���", "����·����",
					"�������վ", "Ⱥ������", "��Ժ", "������", },
			{ "ȫ��������", "������", "��������", "����·", "Ⱥ������", "����" },
			{ "ȫ��������", "���Ͼ���", "�ϼ���", "�������վ", "̫ƽ��", "���������", "��ΰ·" },
			{ "ȫ���ϸ���", "������", "����", "������", "«�ҽ�/���", "ѧ��·", "���½�", "����·����",
					"��Ժ", "�����վ", "�������", },
			{ "ȫ���㷻��", "���ս�", "�����·", "����·", "ľ�Ľ�", "������", },
			{ "ȫ��ƽ����", "�½����", },
			{ "ȫ���ɱ���", "̫����", "��ï���", "��Դ���", },
			{ "ȫ��������", "ѧԺ·", },
			{ "ȫ����", "������", "��־��", "�峣��", "����", "������", "������", "˫����", "ͨ����",
					"������", "ľ����", "������", } };
	// ���а���toplist���
	public static String[] PAIHANGBANG_TOPLIST = new String[] { "�������а�",
			"�����������а�", "�������а�", "�������а�", "�˶��������а�", "�Ƶ����а�", "���������а�" };
	// ��������
	public static int image1[] = { R.drawable.emoji000, R.drawable.emoji001,
			R.drawable.emoji002, R.drawable.emoji003, R.drawable.emoji004,
			R.drawable.emoji005, R.drawable.emoji006, R.drawable.emoji007,
			R.drawable.emoji008, R.drawable.emoji009, R.drawable.emoji010,
			R.drawable.emoji011, R.drawable.emoji012, R.drawable.emoji013,
			R.drawable.emoji014, R.drawable.emoji015, R.drawable.emoji016,
			R.drawable.emoji017, R.drawable.emoji018, R.drawable.emoji019,
			R.drawable.ic_key_delete_normal };

	public static int image2[] = { R.drawable.emoji020, R.drawable.emoji021,
			R.drawable.emoji022, R.drawable.emoji023, R.drawable.emoji024,
			R.drawable.emoji025, R.drawable.emoji026, R.drawable.emoji027,
			R.drawable.emoji101, R.drawable.emoji102, R.drawable.emoji103,
			R.drawable.emoji104, R.drawable.emoji105, R.drawable.emoji106,
			R.drawable.emoji107, R.drawable.emoji108, R.drawable.emoji109,
			R.drawable.emoji110, R.drawable.emoji201, R.drawable.emoji202,
			R.drawable.ic_key_delete_normal };
	public static int image3[] = { R.drawable.emoji203, R.drawable.emoji204,
			R.drawable.emoji205, R.drawable.emoji206, R.drawable.emoji207,
			R.drawable.emoji208, R.drawable.emoji209, R.drawable.emoji210,
			R.drawable.emoji211, R.drawable.emoji212, R.drawable.emoji213,
			R.drawable.emoji214, R.drawable.emoji215, R.drawable.emoji216,
			R.drawable.emoji217, R.drawable.emoji218, R.drawable.emoji219,
			R.drawable.emoji220, R.drawable.emoji221, R.drawable.emoji222,
			R.drawable.ic_key_delete_normal };
	public static int image4[] = { R.drawable.emoji301, R.drawable.emoji302,
			R.drawable.emoji303, R.drawable.emoji304, R.drawable.emoji305,
			R.drawable.emoji306, R.drawable.emoji307, R.drawable.emoji308,
			R.drawable.emoji309, R.drawable.emoji310, R.drawable.emoji311,
			R.drawable.emoji312, R.drawable.emoji313, R.drawable.emoji314,
			R.drawable.emoji315, R.drawable.emoji316,
			R.drawable.ic_key_delete_normal };
}
