function() {

    var env = karate.env; // get system property 'karate.env'
    karate.log('karate.env system property was:', env);

    if (!env) {
        env = 'dev';
    }

    var config = {
        env: env
    };

    if (env == 'dev') {

    }

    return config;
}
