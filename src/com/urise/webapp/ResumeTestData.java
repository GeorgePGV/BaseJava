package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args){
        Resume resume = new Resume("uuid1", "Григорий Кислин");

        SingleLineSection personalQualities = new SingleLineSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");

        SingleLineSection position = new SingleLineSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");

        List<String> achievement = new ArrayList();
        achievement.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\\\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievement.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievement.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        achievement.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievement.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievement.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        BulletedListSection achievements = new BulletedListSection(achievement);

        List<String> qualification = new ArrayList();
        qualification.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualification.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualification.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        qualification.add("MySQL, SQLite, MS SQL, HSQLDB");
        qualification.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
        qualification.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
        qualification.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        qualification.add("Python: Django");
        qualification.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualification.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualification.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        qualification.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,");
        qualification.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        qualification.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования");
        qualification.add("Родной русский, английский \"upper intermediate\"");
        BulletedListSection qualifications = new BulletedListSection(qualification);

        List<Position> organizations = new ArrayList();
        organizations.add(new Position("Java Online Projects","https://javaops.ru/","Автор проекта.","Создание, организация и проведение Java онлайн проектов и стажировок", LocalDate.of(2013, Month.OCTOBER, 1), LocalDate.of(2021, Month.MAY, 1)));
        organizations.add(new Position("Wrike", "https://www.wrike.com/", "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO." , LocalDate.of(2014, Month.OCTOBER, 1), LocalDate.of(2017, Month.JANUARY, 1)));
        organizations.add(new Position("Luxoft (Deutsche Bank)", "https://career.luxoft.com/locations/russia/", "Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5." , LocalDate.of(2010, Month.DECEMBER, 1), LocalDate.of(2012, Month.APRIL, 1)));
        organizations.add(new Position("Yota", "https://www.yota.ru/", "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)", LocalDate.of(2008, Month.JUNE, 1), LocalDate.of(2010, Month.DECEMBER, 1)));
        organizations.add(new Position("Enkata", "https://www.pega.com/products/platform/robotic-process-automation", "Разработчик ПО" , "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).", LocalDate.of(2007, Month.MARCH, 1), LocalDate.of(2008, Month.MAY, 1)));
        organizations.add(new Position("Siemens AG", "https://new.siemens.com/ru/ru.html" , "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).", LocalDate.of(2005, Month.JANUARY, 1), LocalDate.of(2007, Month.DECEMBER, 1)));
        organizations.add(new Position("Alcatel" , "http://www.alcatel.ru/","Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).", LocalDate.of(1997, Month.SEPTEMBER, 1), LocalDate.of(2005, Month.JANUARY, 1)));
        Organization organization = new Organization(organizations);

        List<Position> education = new ArrayList();
        education.add(new Position("Coursera", "https://www.coursera.org/learn/progfun1" , "Student", "\"Functional Programming Principles in Scala\" by Martin Odersky", LocalDate.of(2013, Month.MARCH, 1), LocalDate.of(2013, Month.MAY, 1)));
        education.add(new Position("Luxoft", "https://www.luxoft-training.ru/kurs/obektno-orientirovannyy_analiz_i_proektirovanie_na_uml.html", "Student", "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", LocalDate.of(2011, Month.MARCH, 1), LocalDate.of(2011, Month.APRIL, 1)));
        education.add(new Position("Siemens AG", "https://new.siemens.com/ru/ru.html", "Student", "3 месяца обучения мобильным IN сетям (Берлин)", LocalDate.of(2005, Month.JANUARY, 1), LocalDate.of(2005, Month.APRIL, 1)));
        education.add(new Position("Alcatel", "http://www.alcatel.ru/", "Student", "6 месяцев обучения цифровым телефонным сетям (Москва)", LocalDate.of(1997, Month.SEPTEMBER, 1), LocalDate.of(1998, Month.MARCH, 1)));
        education.add(new Position("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "https://itmo.ru/ru/", "Student", "Аспирантура (программист С, С++)", LocalDate.of(1993, Month.SEPTEMBER, 1), LocalDate.of(1996, Month.JULY, 1)));
        education.add(new Position("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "https://itmo.ru/ru/", "Student", "Инженер (программист Fortran, C)", LocalDate.of(1987, Month.SEPTEMBER, 1), LocalDate.of(1993, Month.JULY, 1)));
        education.add(new Position("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/", "Student", "Закончил с отличием", LocalDate.of(1984, Month.SEPTEMBER, 1), LocalDate.of(1987, Month.JUNE, 1)));
        Organization placesOfEducation = new Organization(education);

        SectionType personal = SectionType.valueOf("PERSONAL");
        System.out.println(personal.getTitle());
        System.out.println(personalQualities.toString());

        SectionType objective = SectionType.valueOf("OBJECTIVE");
        System.out.println(objective.getTitle());
        System.out.println( position.toString());

        SectionType achievement2 = SectionType.valueOf("ACHIEVEMENT");
        System.out.println(achievement2.getTitle());
        System.out.println(achievements.toString());

        SectionType qualifications2 = SectionType.valueOf("QUALIFICATIONS");
        System.out.println(qualifications2.getTitle());
        System.out.println(qualifications.toString());

        SectionType experience = SectionType.valueOf("EXPERIENCE");
        System.out.println(experience.getTitle());
        System.out.println(organization.toString());

        SectionType education2 = SectionType.valueOf("EDUCATION");
        System.out.println(education2.getTitle());
        System.out.println(placesOfEducation.toString());


    }
}
