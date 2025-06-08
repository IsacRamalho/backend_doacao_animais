CREATE TABLE IF NOT EXISTS animais(
    id SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    imagem TEXT,
    tipo TEXT,
    idade INTEGER,
    raca TEXT,
    statusadocao TEXT,
    descr TEXT
);
INSERT INTO animais (nome, tipo, idade, raca, statusadocao, imagem, descr) SELECT 'Rex', 'Cachorro', 3, 'Labrador', 'Disponível', 'https://upload.wikimedia.org/wikipedia/commons/2/26/YellowLabradorLooking_new.jpg', 'Cachorro amigável e brincalhão.' WHERE NOT EXISTS (SELECT 1 FROM ANIMAIS);