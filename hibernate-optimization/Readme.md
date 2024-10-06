# Proje: JPA ve Hibernate Kullanımı

## 1. Proje Yapısı ve Gereksinimler
Bu projede, Spring Boot ile bir mikroservis uygulaması geliştireceğiz. Aşağıdaki teknolojiler ve yaklaşımlar kullanılacaktır:

- **Spring Boot**: Mikroservis uygulamasının temel yapısı.
- **JPA ve Hibernate**: Veri tabanı işlemleri için ORM (Object Relational Mapping) sağlayıcıları.
- **PostgreSQL**: İlişkisel veritabanı olarak kullanılacak.
- **Liquibase**: Veri tabanı şemasının versiyon kontrolünü yönetmek için kullanılacak.
- **Performans Optimizasyonları**: Hibernate seviyesinde yapılacak. Öne çıkan konular:
    - Lazy-Loading
    - 2nd Level Cache
    - Batch Processing

## 2. Veri Tabanı Tasarımı ve İleri Seviye Haritalama
Bu bölümde, veritabanı tasarımı ve entity sınıflarının nasıl haritalandığını ele alacağız. İlişkisel veritabanları için ileri seviye haritalama konularına değineceğiz:

- **İlişkiler**:
    - One-to-One
    - One-to-Many
    - Many-to-One
    - Many-to-Many
- **Annotation Kullanımı**:
    - @JoinTable
    - @JoinColumn
- **Miras Stratejileri**:
    - SINGLE_TABLE
    - TABLE_PER_CLASS
    - JOINED

## 3. Kriter Sorguları (Criteria API)
Bu bölümde, Hibernate’in Criteria API’sini kullanarak dinamik sorgular oluşturacağız:

- **Complex Queries**: Birden fazla koşul içeren sorgular ve fetch join ile performans iyileştirme.
- **Pagination ve Sorting**: Büyük veri kümeleri üzerinde performansı artırmanın yolları.

## 4. Performans İyileştirmeleri
Hibernate ve JPA ile çalışırken karşılaşılabilecek performans sorunlarını ele alacağız:

- **Lazy ve Eager Fetching**: Hangi durumlarda kullanılır ve nasıl yapılandırılır.
- **N+1 Problemi**: Tespiti ve çözüm yöntemleri.
- **Hibernate Second-Level Cache**: Ehcache, Hazelcast gibi yaygın stratejilerin kullanımı.
- **Batch Fetching**: Veri tabanı erişimlerinin toplu yapılması ile performans optimizasyonu.
- **Hibernate Statistics**: Performans metriklerini toplama ve izleme.

## 5. Liquibase ile Veri Tabanı Yönetimi
Liquibase kullanarak veri tabanı versiyon kontrolünü nasıl yapacağımızı göreceğiz:

- **Changelog Dosyaları**: Veri tabanı değişikliklerini takip eden dosyaların oluşturulması ve kullanımı.
- **Versiyon Kontrolü**: Veri tabanı şemasının versiyonlar halinde yönetilmesi.
- **SQL ve XML Bazlı Değişiklikler**: SQL veya XML dosyaları ile veri tabanı değişikliklerinin yönetimi.
