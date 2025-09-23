-- DESTINO / SATELITE / CONVENIENCIA
INSERT INTO lookup(type,code,label) VALUES
 ('DESTINO','LOJA','Loja'),
 ('DESTINO','ECOM','E-commerce'),
 ('DESTINO','CD','Centro de Distribuição'),

 ('SATELITE','A','Satélite A'),
 ('SATELITE','B','Satélite B'),

 ('CONVENIENCIA','A','Conveniência A'),
 ('CONVENIENCIA','B','Conveniência B'),

 ('CICLO','LANCAMENTO','Lançamento'),
 ('CICLO','COLECAO','Coleção'),
 ('CICLO','PERMANENTE','Permanente'),
 ('CICLO','DESCONTINUADO','Descontinuado'),

 ('GENERO','MASC','Masculino'),
 ('GENERO','FEM','Feminino'),
 ('GENERO','UNISSEX','Unissex'),

 ('COLECAO','INVERNO_2026','Inverno 2026'),
 ('COLECAO','VERAO_2026','Verão 2026'),
 ('COLECAO','PERMANENTE','Permanente'),
 ('COLECAO','OPORTUNIDADE','Oportunidade');

-- SUBCOLECAO dependente de COLECAO
INSERT INTO lookup(type,code,label,parent_code) VALUES
 ('SUBCOLECAO','CLASSIC','Classic','INVERNO_2026'),
 ('SUBCOLECAO','OUTDOOR','Outdoor','INVERNO_2026'),
 ('SUBCOLECAO','RUNNING','Running','VERAO_2026'),
 ('SUBCOLECAO','STREET','Street','VERAO_2026');

-- Clientes de exemplo (para presets no formulário)
INSERT INTO customer(name, document, default_destination, default_satellite, default_convenience) VALUES
 ('Cliente Alpha','00.000.000/0001-00','LOJA','A','A'),
 ('Cliente Beta','11.111.111/0001-11','ECOM','B','B');
