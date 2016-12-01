# Clean Code

Dépôt d'exercices effectués durant le cours de *Clean Code*, dispensé par [Rui Carvalho](http://www.rui.fr/),
aux étudiants en 4ème année *Architecture Logicielle* à l'[ESGI](http://www.esgi.fr/) durant l'année scolaire 2016-2017.

## Fizzbuzz

La fonction reçoit en paramètre un nombre entier et renvoie une chaîne de caractères.

Si le paramètre est un multiple de 3, elle renvoie `"fizz"`.

Si le paramètre est un multiple de 5, elle renvoie `"buzz"`.

Si le paramètre est un multiple de 3 **et** de 5, elle renvoie `"fizzbuzz"`.

Sinon, elle renvoie le paramètre transformé en chaîne de caractères (`1` = `"1"`).


## Pairs

La fonction reçoit en paramètre une liste de nombres entiers, et renvoie un couple de valeurs correspondant au plus petit
et au plus grand des produits pouvant être calculés à partir de ces valeurs.

Si la liste en entrée est vide, renvoie `0, 0`.

Si la liste en entrée ne contient qu'un nombre, renvoie ce nombre (`2` = `2, 2`).

Sinon, l'exemple d'entrée `1, 2, 3` donnera en sortie `2, 6`, car `1 * 2 = 2` est le plus petit produit et `2 * 3 = 6` le
plus grand produit dans l'ensemble `1, 2, 3`.