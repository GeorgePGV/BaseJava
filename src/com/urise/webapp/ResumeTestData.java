package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args){
        Resume resume = createResume("uuid1","Григорий Кислин");
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
            System.out.println(resume.getSection(type).getContent());
        }

        for (ContactType type : ContactType.values()) {
            System.out.println(type.getTitle());
            System.out.println(resume.getContact(type));
        }
    }
    public static Resume createResume(String uuid, String fullName){
        Resume resume = new Resume(uuid, fullName);

        SingleLineSection personalQualities = new SingleLineSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");

        SingleLineSection position = new SingleLineSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");

        List<String> achievement = new ArrayList<>();
        achievement.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\\\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievement.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievement.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        achievement.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievement.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievement.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        BulletedListSection achievements = new BulletedListSection(achievement);

        List<String> qualification = new ArrayList<>();
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

        List<Organization> organizations = new ArrayList<>();
        List<Position> javaOnlineProjects= new ArrayList<>();
        javaOnlineProjects.add(new Position("Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок", LocalDate.of(2013, Month.OCTOBER, 1), LocalDate.of(2021, Month.MAY, 1)));
        List<Position> luxoft= new ArrayList<>();
        luxoft.add(new Position("Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.", LocalDate.of(2010, Month.DECEMBER, 1), LocalDate.of(2012, Month.APRIL, 1)));
        List<Position> wrike= new ArrayList<>();
        wrike.add(new Position("Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.", LocalDate.of(2014, Month.OCTOBER, 1), LocalDate.of(2017, Month.JANUARY, 1)));
        List<Position> yota= new ArrayList<>();
        yota.add(new Position("Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)", LocalDate.of(2008, Month.JUNE, 1), LocalDate.of(2010, Month.DECEMBER, 1)));
        List<Position> enkata= new ArrayList<>();
        enkata.add(new Position( "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).", LocalDate.of(2007, Month.MARCH, 1), LocalDate.of(2008, Month.MAY, 1)));
        List<Position> siemens = new ArrayList<>();
        siemens.add(new Position("Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).", LocalDate.of(2005, Month.JANUARY, 1), LocalDate.of(2007, Month.DECEMBER, 1)));
        List<Position> alcatel = new ArrayList<>();
        alcatel.add(new Position("Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).", LocalDate.of(1997, Month.SEPTEMBER, 1), LocalDate.of(2005, Month.JANUARY, 1)));
        organizations.add(new Organization("Java Online Projects", "https://javaops.ru/",javaOnlineProjects));
        organizations.add(new Organization("Wrike", "https://www.wrike.com/", wrike));
        organizations.add(new Organization("Luxoft (Deutsche Bank)", "https://career.luxoft.com/locations/russia/",luxoft));
        organizations.add(new Organization("Yota", "https://www.yota.ru/", yota));
        organizations.add(new Organization("Enkata", "https://www.pega.com/products/platform/robotic-process-automation",enkata));
        organizations.add(new Organization("Siemens AG", "https://new.siemens.com/ru/ru.html", siemens));
        organizations.add(new Organization("Alcatel", "http://www.alcatel.ru/",alcatel));
        OrganizationSection organization = new OrganizationSection(organizations);

        List<Organization> education = new ArrayList<>();
        List<Position> coursera = new ArrayList<>();
        coursera.add( new Position("Student", "\"Functional Programming Principles in Scala\" by Martin Odersky", LocalDate.of(2013, Month.MARCH, 1), LocalDate.of(2013, Month.MAY, 1)));
        List<Position> siemensEd = new ArrayList<>();
        siemensEd.add( new Position("Student","3 месяца обучения мобильным IN сетям (Берлин)", LocalDate.of(2005, Month.JANUARY, 1), LocalDate.of(2005, Month.APRIL, 1)));
        List<Position> luxoftEd = new ArrayList<>();
        luxoftEd.add(new Position( "Student", "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", LocalDate.of(2011, Month.MARCH, 1), LocalDate.of(2011, Month.APRIL, 1)));
        List<Position> alcatelEd = new ArrayList<>();
        alcatelEd.add(new Position("Student", "6 месяцев обучения цифровым телефонным сетям (Москва)", LocalDate.of(1997, Month.SEPTEMBER, 1), LocalDate.of(1998, Month.MARCH, 1)));
        List<Position> university = new ArrayList<>();
        university.add(new Position("Student", "Аспирантура (программист С, С++)", LocalDate.of(1993, Month.SEPTEMBER, 1), LocalDate.of(1996, Month.JULY, 1)));
        university.add(new Position( "Student", "Инженер (программист Fortran, C)", LocalDate.of(1987, Month.SEPTEMBER, 1), LocalDate.of(1993, Month.JULY, 1)));
        List<Position> school = new ArrayList<>();
        school.add(new Position( "Student", "Закончил с отличием", LocalDate.of(1984, Month.SEPTEMBER, 1), LocalDate.of(1987, Month.JUNE, 1)));
        education.add(new Organization("Coursera", "https://www.coursera.org/learn/progfun1",coursera));
        education.add(new Organization("Luxoft", "https://www.luxoft-training.ru/kurs/obektno-orientirovannyy_analiz_i_proektirovanie_na_uml.html",luxoftEd));
        education.add(new Organization("Siemens AG", "https://new.siemens.com/ru/ru.html",siemensEd));
        education.add(new Organization("Alcatel", "http://www.alcatel.ru/", alcatelEd));
        education.add(new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "https://itmo.ru/ru/",university));
        education.add(new Organization("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/",school));
        OrganizationSection placesOfEducation = new OrganizationSection(education);
        resume.setSection(SectionType.valueOf("PERSONAL"), personalQualities);
        resume.setSection(SectionType.valueOf("OBJECTIVE"), position);
        resume.setSection(SectionType.valueOf("ACHIEVEMENT"), achievements);
        resume.setSection(SectionType.valueOf("QUALIFICATIONS"), qualifications);
        resume.setSection(SectionType.valueOf("EXPERIENCE"), organization);
        resume.setSection(SectionType.valueOf("EDUCATION"), placesOfEducation);

        resume.setContact(ContactType.valueOf("PHONE"), "+7(921) 855-0482");
        resume.setContact(ContactType.valueOf("MOBILE"), "-");
        resume.setContact(ContactType.valueOf("HOME_PHONE"), "-");
        resume.setContact(ContactType.valueOf("SKYPE"), "grigory.kislin");
        resume.setContact(ContactType.valueOf("MAIL"), "gkislin@yandex.ru");
        resume.setContact(ContactType.valueOf("LINKEDIN"), "https://www.linkedin.com/in/gkislin");
        resume.setContact(ContactType.valueOf("GITHUB"), "https://github.com/gkislin");
        resume.setContact(ContactType.valueOf("STACKOVERFLOW"), "https://stackoverflow.com/users/548473/grigory-kislin");
        resume.setContact(ContactType.valueOf("HOME_PAGE"), "http://gkislin.ru/");
        return resume;
    }
}