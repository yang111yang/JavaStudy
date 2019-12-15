package com.liu.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
/**
 * ��������ʹ�ã�
 * 	����:
 * 		�������������request��session��application�Ĵ��������ٺ����ݵĸı�
 * 	ʹ��:
 * 		����һ��ʵ����ָ���ӿڵ�java��
 * 			����request--->ServletRequestListener  ����request����Ĵ���������
 * 				requestInitialized(ServletRequestEvent sre)//����
 * 				requestDestroyed(ServletRequestEvent sre)//����
 * 				ע��:
 * 					�βο��Ի�ȡ������request����
 * 					sre.getServletRequest();
 *			����request--->ServletRequestAttributeListener  ����request���������ݵı����
				attributeAdded(ServletRequestAttributeEvent srae)
 * 				attributeRemoved(ServletRequestAttributeEvent srae)	
 * 				attributeReplaced(ServletRequestAttributeEvent srae)
 * 				ע�⣺�βο��Ի�ȡ������������	
 * 					srae.getName()  ��ȡ�������ݵļ�
 * 					srae.getValue() ��ȡ�������ݵ�ֵ
 *			����session--->HttpSessionListener ����session�Ĵ���������
 *				sessionCreated(HttpSessionEvent se)  ����
 *				sessionDestroyed(HttpSessionEvent se) ����
 *				ע�⣺�βο��Ի�ȡ��������session����
 *					se.getSession();
 *			����session--->HttpSessionAttributeListener ����session���ݵı��
 *				attributeAdded(HttpSessionBindingEvent event)
 *				attributeRemoved(HttpSessionBindingEvent event)
 *				attributeReplaced(HttpSessionBindingEvent event)
 *				ע��:�βο��Ի�ȡ������������
 *					event.getName() 	��ȡ���ݵļ���
 *					event.getValue()	��ȡ���ݵ�ֵ
 *			����application--->ServletContextListener ����application����ĳ�ʼ��������
 *				contextInitialized(ServletContextEvent sce) ��ʼ��    ����������
 *				contextDestroyed(ServletContextEvent sce)	����	     �������ر�
 *				ע�⣺
 *					�βο��Ի�ȡ��ǰapplication����
 *					sce.getServletContext();
 			����application--->ServletContextAttributeListener �������ݵı��
 					attributeAdded(ServletContextAttributeEvent event)
 *					attributeRemoved(ServletContextAttributeEvent event)
 *					attributeReplaced(ServletContextAttributeEvent event)
 *				ע�⣺
 *					�βο��Ի�ȡ��ǰ����������
 *					event.getName()  ��ȡ���ݵļ���
 *					event.getValue() ��ȡ���ݵ�ֵ
 * 		��web.xml�����ü�������
 * 			<listener>
				<listener-class>com.bjsxt.listener.MyListener</listener-class>
			</listener>
		������
			ͳ�Ƶ�ǰ����������
			ͳ����ҳ�����������
 * @author MyPC
 *
 */
public class MyListener implements ServletRequestListener,ServletRequestAttributeListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request����������");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("request���󱻳�ʼ����");
		
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("request�����������һ�����ݡ�"+srae.getName()+":"+srae.getValue());
		
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}

}
