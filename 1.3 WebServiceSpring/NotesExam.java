//WebService avec des datas (record)  + jar

//Dependances : starter web


    @GetMapping(REQUEST_PATH_V1)
    public ResponseEntity<String> sayHello(@RequestParam(name = "name", required = false) String name) {
        if (name == null || name.isEmpty()) {
            return ResponseEntity.badRequest().body("Le paramètre 'name' est obligatoire.");
        }
        return ResponseEntity.ok("Hello " + name);
    }
