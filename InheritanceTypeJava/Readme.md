# JPA InheritanceType Kavramı

JPA'da `InheritanceType` kavramı, kalıtım hiyerarşisinin veritabanına nasıl haritalanacağını belirler. Üç temel `InheritanceType` vardır: `SINGLE_TABLE`, `JOINED`, ve `TABLE_PER_CLASS`. Bu türler arasındaki fark, alt sınıfların veritabanında nasıl tablolar oluşturacağı ile ilgilidir. Şimdi bu türleri açıklayalım ve hangi tabloların oluşacağını inceleyelim.

## 1. InheritanceType.SINGLE_TABLE
Tüm sınıflar, bir tek tabloya kaydedilir ve sınıflar arasında ayrım yapmak için bir discriminator column kullanılır.

### Tablolar
Bu türde, sadece tek bir tablo oluşturulur. Tüm alt sınıflar bu tabloda yer alır ve alt sınıfların alanları boş bırakılır veya `NULL` olabilir.

Örneğinizdeki tablolar:
- `SingleTable`
- `SingleTableItem` alt sınıfları ile birlikte tek bir tabloda tutulacaktır.

**Tablolar:** `SingleTable`, `SingleTableItem`

`Glasses`, `Toy` için ayrı tablolar oluşmaz, bunlar `SingleTable`'da tutulur. Aynı şekilde `GlassesItem`, `ToyItem` da `SingleTableItem` tablosunda tutulur.

## 2. InheritanceType.JOINED
Her sınıf için ayrı bir tablo oluşturulur ve alt sınıf tabloları, üst sınıfın anahtarını kullanarak ona katılır. Bu yöntem normalizasyon sağlar ve gereksiz `NULL` değerlerden kaçınır.

### Tablolar
Her sınıf için bir tablo oluşturulur ve alt sınıf tabloları, üst sınıfın `id` sütununu referans alır.

Örneğinizdeki tablolar:
- `BaseItem`
- `GlassesJoin`, `ToyJoin` sınıflarına göre tablolar şu şekilde oluşur:

**Tablolar:** `BaseItem`, `GlassesJoin`, `ToyJoin`

`GlassesJoin` ve `ToyJoin` tabloları, `BaseItem` tablosu ile `id` üzerinden ilişkilendirilir.

## 3. InheritanceType.TABLE_PER_CLASS
Her sınıf için tamamen bağımsız tablolar oluşturulur ve üst sınıfların tabloları ile alt sınıflar arasında hiçbir bağ kurulmaz. Her alt sınıf, sadece kendine ait sütunlarla bir tablo oluşturur.

### Tablolar
Her sınıf için bağımsız bir tablo oluşur; bu tablolar arasında herhangi bir `join` veya bağlantı yoktur.

Örneğinizdeki tablolar:
- `BaseEntityTpc`
- `UserTpc` tabloları:

**Tablolar:** `BaseEntityTpc`, `UserTpc`

`UserTpc` ve `BaseEntityTpc` tamamen bağımsız tablolardır.

## Veritabanında Oluşacak Tablolar

### InheritanceType.SINGLE_TABLE seçildiğinde:
- Tek bir tablo: `SingleTable` (içinde `Glasses`, `Toy`)
- Tek bir tablo: `SingleTableItem` (içinde `GlassesItem`, `ToyItem`)

### InheritanceType.JOINED seçildiğinde:
- Üst sınıf: `BaseItem`
- Alt sınıflar: `GlassesJoin`, `ToyJoin`
- Tablolar: `BaseItem`, `GlassesJoin`, `ToyJoin`

### InheritanceType.TABLE_PER_CLASS seçildiğinde:
- Üst sınıf: `BaseEntityTpc`
- Alt sınıf: `UserTpc`
- Tablolar: `BaseEntityTpc`, `UserTpc` (tamamen bağımsızdır)
