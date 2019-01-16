CREATE TABLE pfm_users
( user_id               UUID         NOT NULL
, username              VARCHAR (30) NOT NULL
, row_version           NUMERIC      NOT NULL DEFAULT 1
, row_hash              VARCHAR (32) NOT NULL
, row_create_ts         TIMESTAMP    NOT NULL
, row_create_user       VARCHAR (32) NOT NULL
, row_create_tx         VARCHAR (32)
, row_modify_ts         TIMESTAMP
, row_modify_user       VARCHAR (32)
, row_modify_tx         VARCHAR (32)
, row_delete_ts         TIMESTAMP
, row_delete_user       VARCHAR (32)
, row_delete_tx         VARCHAR (32)
);

CREATE UNIQUE INDEX user_pki ON pfm_users(user_id);
CREATE UNIQUE INDEX user_username_uki ON pfm_users(username);

ALTER TABLE pfm_users
ADD CONSTRAINT users_pk
PRIMARY KEY USING INDEX user_pki;

ALTER TABLE pfm_users
ADD CONSTRAINT user_username_uk
UNIQUE USING INDEX user_username_uki;

INSERT INTO pfm_users
( user_id
, username
, row_hash
, row_version
, row_create_ts
, row_create_user
)
VALUES
( uuid_generate_v4()
, 'admin'
, MD5('admin')
, 1
, CURRENT_TIMESTAMP
, CURRENT_USER
);
