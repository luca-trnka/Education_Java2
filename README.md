# PFArray Project

## Popis projektu
Tento projekt se zaměřuje na objektovou práci s polem a základy DevOpsu. Je rozšířením předchozího úkolu **Java SE I - static array**, kde jsme pracovali s jedním statickým polem. V tomto úkolu pracujeme s vlastním objektem pole `PFArray`, který umožňuje provádět různé operace nad dynamickým polem.

## Funkcionality objektu PFArray
Objekt `PFArray` umožňuje:
- **Vytvoření pole** - náhodně nebo manuálně
- **Vytištění pole**
- **Vrácení pole**
- **Přidání čísla do pole**
- **Vyhledání největšího čísla**
- **Vyhledání nejmenšího čísla**
- **Součet všech prvků v poli**
- **Odstranění čísla z pole**
- **Smazání celého pole**
- **Přegenerování čísel v poli**

Žádná z funkcí není statická a všechny jsou zapouzdřeny v objektu `PFArray`.

## Otestování objektu PFArray
Všechny metody objektu `PFArray` jsou testovány pomocí **JUnit** testů, aby se ověřilo, že pracují správně s vnitřním stavem objektu.

## Interakce mezi systémem a uživatelem
Uživatel interaguje se systémem pomocí příkazové řádky a má následující možnosti:
1. **Vytvoření nového pole**
2. **Vybrání pole, s kterým chce pracovat**
3. **Práce s vybraným polem**
4. **Vyhledání pole s největším součtem prvků**
5. **Vyhledání pole s nejmenším součtem prvků**

### Podrobnosti k jednotlivým funkcím

#### Vytvoření nového pole
Uživatel může pracovat s několika poli současně. Každé pole je instance objektu `PFArray` a všechna pole jsou uložena v dynamickém seznamu. Při vytvoření nového pole si uživatel zvolí jeho velikost a způsob naplnění (náhodně nebo manuálně).

#### Vybrání pole, s kterým chce pracovat
Uživatel si může zvolit, s kterým polem chce pracovat, a následně nad ním provádět operace, které objekt `PFArray` umožňuje. Tento proces je navržen tak, aby byl co nejjednodušší pro uživatele.

#### Práce s vybraným polem
Uživatel může provádět různé operace nad vybraným polem, například:
- Přidání čísla
- Odstranění čísla
- Přegenerování čísel
- Zobrazení všech prvků

#### Vyhledání pole s největším součtem prvků
Systém projde všechny pole a vybere to s největším součtem všech prvků.

#### Vyhledání pole s nejmenším součtem prvků
Podobně jako u největšího součtu, systém najde pole s nejmenším součtem všech prvků.

## Jak spustit projekt
1. Naklonujte repozitář:
   ```bash
   git clone https://github.com/luca-trnka/Java_Education2.git
