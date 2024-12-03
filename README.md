# ktor-lab

Idag vågar vi drömma om en värld som är exakt likadan som världen vi lever i, fast vi skriver Kotlin istället för Java. Drömmer vi för litet eller för stort? Är det en mardröm? Det kan vi inte veta ännu.

Vi ska bygga en REST-applikation som kan ge användaren en lista på kattraser från ett av användaren specificerat land. Vi behöver knappast ens förklara affärsvärdet i detta. Vi kommer använda oss av Kotlin, Gradle och Ktor, allt annat är än så länge okänt.


![Egyptian Mau](https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Egyptian_Mau_-_Full_Face.jpg/640px-Egyptian_Mau_-_Full_Face.jpg)

*Fig 1. En egyptisk mau, en kattras från Egypten.*

## Arbetet
Vi har delat upp arbetet i tre distinkta delar som kan skrivas parallellt:

### Deluppgift 1
Skapa ett rest-api som tar emot en landskod och skickar ett requestobjekt till domänen.

Förslag på requestobject:
```
BreedRequest
    String countryCode
    boolean onlyIncludeExactMatches
```

### Deluppgift 2
Modellera domänen och bygg logik för att filtrera en respons från Cat Facts APIs breeds-endpoint utifrån kattrasens ursprungsland.
- glöm inte att validera alla domänprimitiv!

### Deluppgift 3
Anropa cat facts api för att hämta en lista av alla breeds.

Responsobjekt:
```
[
  {
    "breed": "string",
    "country": "string",
    "origin": "string",
    "coat": "string",
    "pattern": "string"
  }
]
```

## Resurser
- [Kotlin docs](https://kotlinlang.org/docs/home.html)
- [Ktor docs](https://ktor.io/docs/welcome.html)
- [Gradle docs](https://docs.gradle.org/current/userguide/userguide.html)
- [Cat Facts API](https://catfact.ninja/)
