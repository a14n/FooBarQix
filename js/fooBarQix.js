function getFooBarQix(total) {
    var result = [];
    var values = {
        3: "Foo",
        5: "Bar",
        7: "Qix"
    };
    for (var i = 1; i <= total; i++) {
        var numberRepresentation = "";
        var found = false;
        for (var num in values) {
            if (i % num === 0) {
                numberRepresentation += values[num];
                found = true;
            }
        }
        var iAsString = String(i);
        for (var j = 0; j < iAsString.length; j++) {
            var digit = Number(iAsString.charAt(j));
            var value = values[digit];
            if (typeof (value) !== "undefined") {
                numberRepresentation += value;
                found = true;
            }
        }
        if (!found) {
            numberRepresentation += i;
        }
        result.push(numberRepresentation);
    }
    return result;
}
